module comp20050.hexagonalboard {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    // JUnit API needed for compiling test sources (but not needed in the main module)
    // requires org.junit.jupiter.api;

    // Allow JavaFX FXML to access your controller
    opens comp20050.hexagonalboard to javafx.fxml, org.junit.platform.commons;

    // Allow JUnit and reflection-based tools (like Mockito) to access internal classes

    // Export the package so it can be used by the app
    exports comp20050.hexagonalboard;
}
