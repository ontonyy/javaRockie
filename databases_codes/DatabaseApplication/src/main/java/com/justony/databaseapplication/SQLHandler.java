package com.justony.databaseapplication;

import com.justony.databaseapplication.exceptions.DatabaseExistException;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class SQLHandler {
    private static SQLHandler instance = null;
    private Connection conn;
    private List<String> databases = new LinkedList<>();
    public static String dbName;

    public static SQLHandler getInstance() {
        if (instance == null) {
            instance = new SQLHandler();
        }
        return instance;
    }

    public List<String> getDatabaseTables(String db) {
        List<String> tables = new LinkedList<>();
        try {
            PreparedStatement useDb = conn.prepareStatement("USE " + db);
            useDb.executeUpdate();
            PreparedStatement databasesQuery = conn.prepareStatement("SHOW TABLES");
            ResultSet rs = databasesQuery.executeQuery();
            while (rs.next()) {
                tables.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tables;
    }

    public void setDatabases() {
        databases.clear();
        try (PreparedStatement databasesQuery = conn.prepareStatement("SHOW DATABASES")) {
            ResultSet rs = databasesQuery.executeQuery();
            while (rs.next()) {
                databases.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isDatabaseExist(String name) {
        setDatabases();
        for (String database : databases) {
            if (database.equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public void createDatabase(String dbName) throws SQLException, DatabaseExistException {
        if (!isDatabaseExist(dbName)) {
            PreparedStatement databasesQuery = conn.prepareStatement("CREATE DATABASE " + dbName);
            databasesQuery.executeUpdate();
        } else {
            throw new DatabaseExistException();
        }
    }

    public void deleteDatabase(String dbName) throws SQLException {
        if (isDatabaseExist(dbName)) {
            PreparedStatement databasesQuery = conn.prepareStatement("DROP DATABASE " + dbName);
            databasesQuery.executeUpdate();
        }
    }

    public boolean isTableExist(String name) {
        for (String table : getDatabaseTables(dbName)) {
            if (table.equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public void createTable(String tableName) throws SQLException {
        if (!isTableExist(tableName)) {
            PreparedStatement useDb = conn.prepareStatement("USE " + dbName);
            useDb.executeUpdate();
            PreparedStatement databasesQuery = conn.prepareStatement("CREATE TABLE " + tableName);
            databasesQuery.executeUpdate();
        }
    }

    public void deleteTable(String tableName) throws SQLException {
        if (isTableExist(tableName)) {
            PreparedStatement useDb = conn.prepareStatement("USE " + dbName);
            useDb.executeUpdate();
            PreparedStatement databasesQuery = conn.prepareStatement("DROP TABLE " + tableName);
            databasesQuery.executeUpdate();
        }
    }

    public List<String> getDatabases() {
        setDatabases();
        return databases;
    }

    public void setConnection(String username, String password) throws Exception {
        String dbUrl = "jdbc:mysql://localhost:3306";
        conn = DriverManager.getConnection(dbUrl, username, password);
    }
}
