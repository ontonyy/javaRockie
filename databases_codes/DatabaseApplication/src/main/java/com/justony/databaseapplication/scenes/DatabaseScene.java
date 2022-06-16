package com.justony.databaseapplication.scenes;

import com.justony.databaseapplication.MainScene;
import com.justony.databaseapplication.SQLHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;

public class DatabaseScene {
    @FXML private TextField tableName;
    @FXML private Label dbName;
    @FXML private Label wrongLabel;
    @FXML private Button helpBtn;
    @FXML private ListView<String> tables;

    private HelpScene helpScene = new HelpScene("""
                In this screen you can create new table
                or click on existed database table,
                and open action screen with this table,
                left mouse click(open), right(delete)""", 400, 300);

    @FXML public void initialize() {
        String name = SQLHandler.dbName;
        dbName.setText(name);
        for (String table : SQLHandler.getInstance().getDatabaseTables(name)) {
            tables.getItems().add(table);
        }
        helpBtn.hoverProperty().addListener(e -> helpScene.showStage());
    }

    @FXML public void handleMouseClick(MouseEvent event) {
        MouseButton btn = event.getButton();
        String table = tables.getSelectionModel().getSelectedItem();
        if (btn == MouseButton.PRIMARY) {
            System.out.println("left click");
        } else if (btn == MouseButton.SECONDARY) {
            try {
                SQLHandler.getInstance().deleteTable(table);
                tables.getItems().remove(table);
            } catch (SQLException e) {
                wrongLabel.setText("Table error!");
            }
        }
    }

    @FXML public void backToConnect() {
        MainScene.changeScene("database_connect.fxml");
    }

    @FXML public void createTable() {
        String name = tableName.getText();
        try {
            SQLHandler.getInstance().createTable(name);
        } catch (Exception ex) {
            wrongLabel.setText("Something wrong!");
        }
    }
}
