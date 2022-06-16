package com.ontony.blockchaininterface.scenes;

import com.ontony.blockchaininterface.auxilaries.UserData;
import com.ontony.blockchaininterface.auxilaries.UserDataHandler;
import com.ontony.blockchaininterface.blockchain.User;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.io.IOException;

public class UsersListScene {
    @FXML public ListView<String> users;
    public static int height = 0;

    @FXML public void initialize() throws IOException {
        height = 0;
        for (User user : UserDataHandler.getAllUsers()) {
            if (!user.name.equalsIgnoreCase(UserData.nameText)) {
                users.getItems().add("User: " + user.name);
                height += 25;
            }
        }
    }
}
