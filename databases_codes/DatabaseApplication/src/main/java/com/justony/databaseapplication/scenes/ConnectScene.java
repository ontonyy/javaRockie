package com.justony.databaseapplication.scenes;

import com.justony.databaseapplication.Constants;
import com.justony.databaseapplication.MainScene;
import com.justony.databaseapplication.RecoverHandler;
import com.justony.databaseapplication.SQLHandler;
import com.justony.databaseapplication.exceptions.DatabaseExistException;
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

    private HelpScene helpScene = new HelpScene("""
                Here you can create new database
                or open database by clicking on it
                or by writing the name of database""");

    @FXML public void initialize() {
        recoverBtn.setVisible(false);
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
                SQLHandler.dbName = db;
                MainScene.changeScene("database_view.fxml");
            } else if (buttonDelete != null && result == buttonDelete) {
                RecoverHandler.deleteName = db;
                databases.getItems().remove(db);
                startRecover();
            }
        }
    }

    public void startRecover() {
        recoverBtn.setVisible(true);
        String text = "Recover " + RecoverHandler.deleteName;
        recoverBtn.setText(text);
        recoverBtn.setPrefWidth(text.length() * 11);
        recoverBtn.setLayoutX(175 - (text.length() * 2.5));
        RecoverHandler.pause.setOnFinished(event -> {
            recoverBtn.setVisible(false);
            try {
                SQLHandler.getInstance().deleteDatabase(RecoverHandler.deleteName);
            } catch (SQLException ex) {
                displayWrongLabel("Something wrong!");
            }
            RecoverHandler.deleteName = "";
        });
        RecoverHandler.pause.play();
    }

    @FXML public void recoverAction() {
        RecoverHandler.pause.stop();
        updateDatabases();
        recoverBtn.setVisible(false);
    }

    @FXML public void openDb() {
        if (database.getText().isEmpty()) {
            wrongLabel.setText("Database not exist!");
        } else {
            SQLHandler.dbName = database.getText();
            MainScene.changeScene("database_view.fxml");
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
