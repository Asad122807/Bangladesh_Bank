package com.summer26.section3.group29.simulatingoperationsofbangladeshbank.Asrar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class DowntimeMonitoringController {

    @FXML private ComboBox<String> systemTypeComboBox;
    @FXML private TextField bankSearchTextField;
    @FXML private DatePicker outageDatePicker;
    @FXML private Button filterButton;
    @FXML private Button refreshButton;

    @FXML private TableView<?> downtimeTableView;
    @FXML private TableColumn<?, ?> incidentIdColumn;
    @FXML private TableColumn<?, ?> systemNameColumn;
    @FXML private TableColumn<?, ?> affectedBankColumn;
    @FXML private TableColumn<?, ?> startTimeColumn;
    @FXML private TableColumn<?, ?> durationColumn;
    @FXML private TableColumn<?, ?> recoveryStatusColumn;

    @FXML private Label totalOutagesLabel;
    @FXML private Button backButton;

    @FXML
    public void initialize() {
        if (systemTypeComboBox != null) {
            systemTypeComboBox.getItems().addAll("All Systems", "RTGS", "BEFTN", "NPSB", "MFS Gateway");
            systemTypeComboBox.getSelectionModel().selectFirst();
        }
    }

    @FXML
    private void handleFilterAction(ActionEvent event) {
        String system = systemTypeComboBox.getValue();
        String bank = bankSearchTextField.getText();
        System.out.println("Filtering Downtime Logs - System: " + system + ", Bank: " + bank);
    }

    @FXML
    private void handleRefreshAction(ActionEvent event) {
        System.out.println("Refreshing downtime reports...");
        systemTypeComboBox.getSelectionModel().selectFirst();
        bankSearchTextField.clear();
        outageDatePicker.setValue(null);
    }

    @FXML
    private void handleBackAction(ActionEvent event) {
        System.out.println("Navigating back to Payment Systems Officer Dashboard...");
    }
}