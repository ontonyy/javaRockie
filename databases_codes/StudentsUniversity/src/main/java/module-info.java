module com.example.studentsuniversity {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.studentsuniversity to javafx.fxml;
    exports com.example.studentsuniversity;
}