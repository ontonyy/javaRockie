package com.justony.databaseapplication.scenes;

import com.justony.databaseapplication.SQLHandler;
import com.justony.databaseapplication.MainScene;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class StartScene {
    @FXML private TextField username;
    @FXML private TextField password;
    @FXML private Label wrongData;
    @FXML private Button helpBtn;

    private HelpScene helpScene = new HelpScene("""
                    To start application run you
                    sql server in xampp or other
                    app and then write name and
                    password and click button""");

    @FXML public void initialize() {
        helpBtn.hoverProperty().addListener(e -> helpScene.showStage());
    }

    @FXML
    public void startApp() {
        String user = "root";
        String pass = "";
        if (!username.getText().isEmpty()) {
            user = username.getText();
            pass = password.getText();
        }
        try {
            SQLHandler.getInstance().setConnection(user, pass);
            MainScene.changeScene("database_connect.fxml");
        } catch (Exception e) {
            wrongData.setText("Cannot connect!");
        }
    }
}
