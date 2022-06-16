package com.ontony.blockchaininterface.scenes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ontony.blockchaininterface.MainScene;
import com.ontony.blockchaininterface.blockchain.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AdminScene {
    @FXML
    private ListView<String> usersList;
    @FXML
    private ListView<String> usersList2;
    @FXML
    private Label adminInfo;
    private MainScene scene = new MainScene();

    @FXML
    public void initialize() throws IOException {
        File[] usersFiles = new File("users").listFiles();
        int count = 0;
        if (usersFiles != null && usersFiles.length > 0) {
            for (File file : usersFiles) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                Reader reader = Files.newBufferedReader(Paths.get(file.getPath()));
                User user = gson.fromJson(reader, User.class);
                if (user != null) {
                    if (count > 6) {
                        usersList2.getItems().add(user.getUsableString());
                    } else {
                        usersList.getItems().add(user.getUsableString());
                    }
                }
                count++;
            }
        } else {
            adminInfo.setText("No users!");
        }
    }

    @FXML public void handleMouseClick(MouseEvent event) throws IOException {
        String userData = usersList.getSelectionModel().getSelectedItem();
        String name = userData.split("User: ")[1].split("\n")[0];
        String balance = userData.split("balance: ")[1].split("\\$")[0].trim();
        scene.openUserScene(name, balance);
    }


    public void goBackToLogin() throws IOException {
        scene.changeScene("login.fxml");
    }

}
