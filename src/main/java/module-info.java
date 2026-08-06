module com.summer26.section3.group29.simulatingoperationsofbangladeshbank {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.summer26.section3.group29.simulatingoperationsofbangladeshbank to javafx.fxml;
    opens com.summer26.section3.group29.simulatingoperationsofbangladeshbank.Asad to javafx.fxml;

    exports com.summer26.section3.group29.simulatingoperationsofbangladeshbank;
    exports com.summer26.section3.group29.simulatingoperationsofbangladeshbank.Asad;
}