package com.justony.databaseapplication;

import java.util.LinkedList;
import java.util.List;

public class HelpUtils {

    public static List<String> getTypes() {
        return new LinkedList<>(List.of("INT", "VARCHAR", "TEXT", "DATE", "BOOL", "CHAR", "ENUM", "SET",
                "BINARY", "VARBINARY", "TINYBLOB", "TINYTEXT", "BLOB", "MEDIUMTEXT", "MEDIUMBLOB", "LONGTEXT", "LONGBLOB",
                "BIT", "TINYINT", "SMALLINT", "MEDIUMINT", "BIGINT", "FLOAT", "DOUBLE", "DECIMAL", "DATETIME", "TIMESTAMP",
                "TIME", "YEAR"));
    }

    public static List<String> getIndexes() {
        return new LinkedList<>(List.of("AUTO INCREMENT", "DEFAULT", "PRIMARY KEY", "NULL", "UNIQUE", "INDEX", "SPATIAL"));
    }

    public static int countStringRows(String text) {
        String[] str = text.split("\n");
        return str.length;
    }

    public static int countStringColumns(String text) {
        String[] str = text.split("\n");
        int maxCount = 0;
        for (String s : str) {
            if (s.length() > maxCount) {
                maxCount = s.length();
            }
        }
        return maxCount;
    }

}
