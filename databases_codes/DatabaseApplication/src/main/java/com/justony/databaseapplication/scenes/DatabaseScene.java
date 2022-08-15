package com.justony.databaseapplication.scenes;

import com.justony.databaseapplication.MainScene;
import com.justony.databaseapplication.recover.RecoverHandler;
import com.justony.databaseapplication.SQLHandler;
import com.justony.databaseapplication.recover.RecoverType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;

public class DatabaseScene {
    @FXML private TextField tableNameLabel;
    @FXML private Label dbNameLabel;
    @FXML private Label wrongLabel;
    @FXML private Button helpBtn;
    @FXML private Button recoverBtn;
    @FXML private ListView<String> tables;
    private RecoverHandler recover;
    public static String tableName = "";

    public static DatabaseScene instance = null;

    private HelpScene helpScene = new HelpScene("""
                In this screen you can create new table
                or click on existed database table,
                and open action screen with this table,
                left mouse click(open), right(delete)""", 400, 300);

    @FXML public void initialize() {
        if (instance == null) {
            instance = this;
        }
        recover = new RecoverHandler(recoverBtn, RecoverType.TABLE);
        updateTables();
        dbNameLabel.setText(SQLHandler.dbName);
        helpBtn.hoverProperty().addListener(e -> helpScene.showStage());
    }

    public void addTable(String table) {
        tables.getItems().add(table);
    }

    public void updateTables() {
        tables.getItems().clear();
        for (String table : SQLHandler.getInstance().getDatabaseTables(SQLHandler.dbName)) {
            addTable(table);
        }
    }

    @FXML public void handleMouseClick(MouseEvent event) {
        MouseButton btn = event.getButton();
        String table = tables.getSelectionModel().getSelectedItem();
        if (btn == MouseButton.PRIMARY) {
            System.out.println("left click");
        } else if (btn == MouseButton.SECONDARY) {
            tables.getItems().remove(table);
            try {
                recover.startRecover(table);
            } catch (SQLException e) {
                wrongLabel.setText("Table error!");
            }
        }
    }

    @FXML public void backToConnect() {
        MainScene.changeScene("database_connect.fxml");
    }

    @FXML public void createTable() {
        try {
            tableName = tableNameLabel.getText();
            MainScene.openScene("table_creation.fxml");
            tableNameLabel.setText("");
        } catch (Exception ex) {
            wrongLabel.setText("Something wrong!");
            ex.printStackTrace();
        }
    }

    @FXML public void recoverAction() {
        recover.act();
        updateTables();
    }
}
