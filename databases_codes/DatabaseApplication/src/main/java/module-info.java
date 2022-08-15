module com.justony.databaseapplication {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.justony.databaseapplication to javafx.fxml;
    exports com.justony.databaseapplication;
    exports com.justony.databaseapplication.scenes;
    opens com.justony.databaseapplication.scenes to javafx.fxml;
    exports com.justony.databaseapplication.recover;
    opens com.justony.databaseapplication.recover to javafx.fxml;
}