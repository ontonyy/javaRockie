package com.ontony.blockchaininterface.scenes;

import com.google.gson.GsonBuilder;
import com.ontony.blockchaininterface.MainScene;
import com.ontony.blockchaininterface.auxilaries.UserDataHandler;
import com.ontony.blockchaininterface.blockchain.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LoginScene {
    @FXML
    private Label wrongName;
    @FXML
    private TextField username, balance;
    private MainScene scene = new MainScene();

    public void createUser() throws Exception {
        String name = username.getText();
        String balanceText = balance.getText();
        if (!name.isEmpty()) {
            User existsUser = UserDataHandler.getUserByName(name);
            if (existsUser != null) {
                wrongName.setText("User exists!");
                scene.openUserScene(existsUser.name, String.valueOf(existsUser.balance));
            } else {
                if (!balanceText.matches("\\d+") || balanceText.isEmpty()) {
                    wrongName.setText("Incorrect balance!");
                } else {
                    File file = new File("users/" + name.toLowerCase() + ".json");
                    file.createNewFile();
                    wrongName.setText("Success, go in...");

                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    User user = new User(name, Integer.parseInt(balanceText));
                    Writer writer = Files.newBufferedWriter(Paths.get(file.getPath()));
                    gson.toJson(user, writer);
                    writer.close();

                    scene.openUserScene(name, balanceText);
                }
            }
        } else {
            wrongName.setText("Write full user info!");
        }
    }

    public void openAdminWindow() throws IOException {
//        JPasswordField pf = new JPasswordField();
//        int option = JOptionPane.showConfirmDialog(null, pf, "Enter password: ", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
//        if (option == 0) {
//            String password = new String(pf.getPassword());
//            if (password.equals("12344321")) {
//                scene.changeScene("admin_users_info.fxml");
//            }
//        }
        scene.changeScene("admin_users_info.fxml");
    }
}
