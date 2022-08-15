package com.justony.databaseapplication.recover;

import com.justony.databaseapplication.SQLHandler;
import com.justony.databaseapplication.recover.RecoverType;
import javafx.animation.PauseTransition;
import javafx.scene.control.Button;
import javafx.scene.layout.Region;
import javafx.util.Duration;

import java.sql.SQLException;

public class RecoverHandler {
    private PauseTransition pause = new PauseTransition(Duration.seconds(5));
    private RecoverType type;
    private Button btn;
    private String deleteName = "";

    public RecoverHandler(Button btn, RecoverType type) {
        this.type = type;
        this.btn = btn;
        this.btn.setVisible(false);
    }


    public void checkRecover() throws SQLException {
        if (!deleteName.equalsIgnoreCase("")) {
            deleteDb();
            pause.stop();
        }
    }

    public void deleteDb() throws SQLException {
        if (type == RecoverType.DATABASE) {
            SQLHandler.getInstance().deleteDatabase(deleteName);
        } else {
            SQLHandler.getInstance().deleteTable(deleteName);
        }
        deleteName = "";
    }

    public void startRecover(String name) throws SQLException {
        checkRecover();
        deleteName = name;
        setRecoverBtn();

        pause.setOnFinished(event -> {
            btn.setVisible(false);
            try {
                deleteDb();
            } catch (SQLException ignored) {}
        });
        pause.play();
    }

    private void setRecoverBtn() {
        btn.setVisible(true);
        String text = "Recover " + deleteName;
        int len = text.length();
        btn.setText(text);

        if (type == RecoverType.DATABASE) {
            double dtX = 3;
            if (len < 12) {
                dtX = 1.5;
            } else if (len < 20) {
                dtX = 2;
            }
            btn.setLayoutX(170 - len * dtX);
        } else {
            btn.setLayoutX(24);
        }
    }

    public void act() {
        deleteName = "";
        pause.stop();
        btn.setVisible(false);
    }
}
