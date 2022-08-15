package com.justony.databaseapplication.scenes;

import com.justony.databaseapplication.Constants;
import com.justony.databaseapplication.MainScene;
import com.justony.databaseapplication.recover.RecoverHandler;
import com.justony.databaseapplication.SQLHandler;
import com.justony.databaseapplication.exceptions.DatabaseExistException;
import com.justony.databaseapplication.recover.RecoverType;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.sql.SQLException;
import java.util.List;

public class ConnectScene {
    @FXML private Label wrongLabel;
    @FXML private TextField database;
    @FXML private TextField nameDb;
    @FXML private Button helpBtn;
    @FXML private Button recoverBtn;
    @FXML private ListView<String> databases;

    private RecoverHandler recover;

    private HelpScene helpScene = new HelpScene("""
                Here you can create new database
                or open database by clicking on it
                or by writing the name of database""");

    @FXML public void initialize() {
        recover = new RecoverHandler(recoverBtn, RecoverType.DATABASE);
        updateDatabases();
        helpBtn.hoverProperty().addListener(e -> helpScene.showStage());
    }

    @FXML public void handleMouseClick(MouseEvent arg0) {
        String db = databases.getSelectionModel().getSelectedItem();
        if (db != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Action with " + db);
            alert.setHeaderText("What to do with database, choose option.");

            ButtonType buttonOpen = new ButtonType("Open");
            ButtonType buttonCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
            ButtonType buttonDelete = null;
            alert.getButtonTypes().setAll(buttonOpen, buttonCancel);
            if (!Constants.nonDeleteDbs.contains(db)) {
                buttonDelete = new ButtonType("Delete");
                alert.getButtonTypes().add(buttonDelete);
            }

            ButtonType result = alert.showAndWait().get();

            if (result == buttonOpen) {
                openDatabaseScene(db);
            } else if (buttonDelete != null && result == buttonDelete) {
                databases.getItems().remove(db);
                try {
                    recover.startRecover(db);
                } catch (SQLException ex) {
                    displayWrongLabel("Something wrong!");
                }
            }
        }
    }

    @FXML public void recoverAction() {
        recover.act();
        updateDatabases();
    }

    public void openDatabaseScene(String db) {
        try {
            recover.checkRecover();
            SQLHandler.dbName = db;
            MainScene.changeScene("database_view.fxml");
        } catch (SQLException ex) {
            displayWrongLabel("Something wrong!");
        }
    }

    @FXML public void openDb() {
        if (database.getText().isEmpty()) {
            wrongLabel.setText("Database not exist!");
        } else {
            openDatabaseScene(database.getText());
        }
        database.setText("");
    }

    public void updateDatabases() {
        databases.getItems().clear();
        List<String> dbs = SQLHandler.getInstance().getDatabases();
        for (String db : dbs) {
            databases.getItems().add(db);
        }
    }

    @FXML public void createDb() {
        if (nameDb.getText().isEmpty()) {
            displayWrongLabel("Name field is empty!");
        } else {
            try {
                SQLHandler.getInstance().createDatabase(nameDb.getText());
                updateDatabases();
            } catch (SQLException e) {
                displayWrongLabel("Cannot create database!");
            } catch (DatabaseExistException e) {
                displayWrongLabel("Database exist!");
            }
        }
        nameDb.setText("");

    }

    public void displayWrongLabel(String text) {
        wrongLabel.setText(text);
        PauseTransition pause = new PauseTransition(Duration.seconds(5));
        pause.setOnFinished(e -> wrongLabel.setText(""));
        pause.play();
    }

}
