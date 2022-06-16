package com.ontony.blockchaininterface;

import com.ontony.blockchaininterface.auxilaries.UserData;
import com.ontony.blockchaininterface.scenes.UsersListScene;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
public class MainScene extends Application {
    private static Stage main;

    @Override
    public void start(Stage stage) throws Exception {
        main = stage;

        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage.setTitle("Super mega blockchain");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();

    }

    public void changeScene(String fxml) throws IOException {
        main.getScene().setRoot(getScenePane(fxml));
    }

    public Parent getScenePane(String fxml) throws IOException {
        return FXMLLoader.load(getClass().getResource(fxml));
    }

    public void openUserScene(String name, String balance) throws IOException {
        UserData.nameText = name;
        UserData.balanceText = balance;
        Parent pane = FXMLLoader.load(getClass().getResource("user_chain.fxml"));
        main.getScene().setRoot(pane);
    }

    public void createNewScene(String fxml) throws IOException {
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setTitle("Users");
        Scene scene = new Scene(getScenePane(fxml), 200, UsersListScene.height);
        stage.setScene(scene);
        stage.show();
        stage.setOnHidden(e -> UsersListScene.height = 0);
    }
}
