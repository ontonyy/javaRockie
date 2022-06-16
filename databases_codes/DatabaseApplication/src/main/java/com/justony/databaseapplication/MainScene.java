package com.justony.databaseapplication;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class MainScene extends Application {
    private static Stage main;

    @Override
    public void start(Stage stage) throws IOException {
        main = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("start_view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Start database app");
        stage.setScene(scene);
        stage.show();
    }

    public static void changeScene(String fxml) {
        try {
            Parent sceneParent = FXMLLoader.load(MainScene.class.getResource(fxml));
            String title = fxml.replaceAll("_", " ");
            main.setTitle(title.substring(0, 1).toUpperCase() + title.substring(1, title.length() - 5));
            main.getScene().setRoot(sceneParent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}