module com.summer26.section3.group29.simulatingoperationsofbangladeshbank {
    requires javafx.controls;
    requires javafx.fxml;

    // Open main package to JavaFX
    opens com.summer26.section3.group29.simulatingoperationsofbangladeshbank to javafx.fxml;

    // OPEN THE SUB-PACKAGE 'Asad' TO JAVAFX
    opens com.summer26.section3.group29.simulatingoperationsofbangladeshbank.Asad to javafx.fxml;

    exports com.summer26.section3.group29.simulatingoperationsofbangladeshbank;
    exports com.summer26.section3.group29.simulatingoperationsofbangladeshbank.Asad;
}