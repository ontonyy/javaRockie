package com.justony.databaseapplication;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainScene extends Application {
    private static Stage main;
    private static Stage secondary;

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

    public static void setSecondaryNull() {
        secondary = null;
    }

    public static void openScene(String fxml) {
        if (secondary == null) {
            try {
                secondary = new Stage();
                Parent root = FXMLLoader.load(MainScene.class.getResource(fxml));
                secondary.setScene(new Scene(root, 700, 125));
                secondary.show();
                secondary.setOnCloseRequest(event -> {
                    secondary = null;
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Stage getSecondary() {
        return secondary;
    }

    public static void main(String[] args) {
        launch();
    }
}