module com.ontony.blockchaininterface {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    requires com.google.gson;

    opens com.ontony.blockchaininterface to javafx.fxml;
    exports com.ontony.blockchaininterface;
    exports com.ontony.blockchaininterface.blockchain;
    opens com.ontony.blockchaininterface.blockchain to javafx.fxml;
    exports com.ontony.blockchaininterface.scenes;
    opens com.ontony.blockchaininterface.scenes to javafx.fxml;
    exports com.ontony.blockchaininterface.auxilaries;
    opens com.ontony.blockchaininterface.auxilaries to javafx.fxml;
}