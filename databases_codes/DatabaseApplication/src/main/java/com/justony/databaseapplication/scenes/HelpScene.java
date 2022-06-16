package com.justony.databaseapplication.scenes;

import com.justony.databaseapplication.HelpUtils;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelpScene {

    private Stage stage = new Stage();
    private int x, y;
    private boolean open = true;

    public HelpScene(String text) {
        setStage(text);
    }

    public HelpScene(String text, int x, int y) {
        setStage(text);
        stage.setX(x);
        stage.setY(y);
    }

    private void setStage(String text) {
        stage.setTitle("Help window");
        Text label = new Text(text);
        Font font = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 18);
        label.setFont(font);
        label.setFill(Color.valueOf("#0022ff"));

        int height = HelpUtils.countStringRows(text) * 30;
        int width = HelpUtils.countStringColumns(text) * 11;

        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label);
        stage.setScene(new Scene(layout1, width, height));
    }

    public void showStage() {
        if (open) {
            stage.show();
            open = false;
        } else {
            stage.close();
            open = true;
        }
    }
}
