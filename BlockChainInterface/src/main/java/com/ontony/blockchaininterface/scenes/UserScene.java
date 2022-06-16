package com.ontony.blockchaininterface.scenes;

import com.ontony.blockchaininterface.MainScene;
import com.ontony.blockchaininterface.auxilaries.UserData;
import com.ontony.blockchaininterface.auxilaries.UserDataHandler;
import com.ontony.blockchaininterface.blockchain.Block;
import com.ontony.blockchaininterface.blockchain.BlockType;
import com.ontony.blockchaininterface.blockchain.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.IOException;


public class UserScene {
    @FXML
    public Label username, balance;
    @FXML
    public ListView<Node> blocks;
    @FXML
    public TextField receiverName, senderMoney;
    @FXML
    public Label wrongInput;

    private User mainUser;

    private MainScene main = new MainScene();

    @FXML
    public void initialize() throws IOException {
        mainUser = UserDataHandler.getUserByName(UserData.nameText);
        if (mainUser != null) {
            username.setText(mainUser.name);
            initializeLabels();
        }
    }

    public void initializeLabels() {
        blocks.getItems().clear();
        for (Block block : mainUser.getBlocks()) {
            Text text = new Text(block.toString());
            if (block.type == BlockType.CONSUMPTION) {
                text.setFill(Color.RED);
            } else {
                text.setFill(Color.GREEN);
            }
            blocks.getItems().add(text);
        }
        balance.setText(mainUser.balance + "$");
    }

    public void goBackToLogin() throws IOException {
        main.changeScene("login.fxml");
    }

    public void prepareTransaction(ActionEvent event) throws IOException {
        String name = receiverName.getText();
        String money = senderMoney.getText();
        if (!name.isEmpty() && !money.isEmpty()) {
            if (!name.equalsIgnoreCase(username.getText())) {
                User receiver = UserDataHandler.getUserByName(name);
                createTransaction(receiver, money);
            } else {
                wrongInput.setText("Users same names!");
            }
        } else {
            wrongInput.setText("Fill full form!");
        }
    }

    public void createTransaction(User receiver, String money) throws IOException {
        if (receiver != null && mainUser != null) {
            boolean transSuccess = mainUser.userBlockChain.addBlockAndCreateTransaction(mainUser, receiver, Integer.parseInt(money));
            if (transSuccess) {
                initializeLabels();
                UserDataHandler.updateUserFile(receiver);
                UserDataHandler.updateUserFile(mainUser);
            } else {
                wrongInput.setText("User have no money!");
            }
        } else {
            wrongInput.setText("User not exists!");
        }
    }

    public void openUsersWindow() throws IOException {
        main.createNewScene("usersList.fxml");
    }
}
