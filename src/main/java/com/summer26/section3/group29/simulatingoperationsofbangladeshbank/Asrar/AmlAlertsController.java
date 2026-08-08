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

public class AmlAlertsController {

    @FXML private TextField alertIdTextField;
    @FXML private ComboBox<String> severityComboBox;
    @FXML private DatePicker alertDatePicker;
    @FXML private Button filterButton;
    @FXML private Button refreshButton;

    @FXML private TableView<?> amlAlertsTableView;
    @FXML private TableColumn<?, ?> alertIdColumn;
    @FXML private TableColumn<?, ?> accountNumberColumn;
    @FXML private TableColumn<?, ?> customerNameColumn;
    @FXML private TableColumn<?, ?> alertTypeColumn;
    @FXML private TableColumn<?, ?> severityColumn;
    @FXML private TableColumn<?, ?> statusColumn;

    @FXML private Label totalAlertsLabel;
    @FXML private Button investigateButton;
    @FXML private Button backButton;

    @FXML
    public void initialize() {
        if (severityComboBox != null) {
            severityComboBox.getItems().addAll("All Levels", "Critical", "High", "Medium", "Low");
            severityComboBox.getSelectionModel().selectFirst();
        }
    }

    @FXML
    private void handleFilterAction(ActionEvent event) {
        String alertId = alertIdTextField.getText();
        String severity = severityComboBox.getValue();
        System.out.println("Filtering AML Alerts - Alert ID: " + alertId + ", Severity: " + severity);
    }

    @FXML
    private void handleRefreshAction(ActionEvent event) {
        System.out.println("Refreshing AML Alerts data...");
        alertIdTextField.clear();
        severityComboBox.getSelectionModel().selectFirst();
        alertDatePicker.setValue(null);
    }

    @FXML
    private void handleInvestigateAction(ActionEvent event) {
        System.out.println("Opening investigation details for selected alert...");
    }

    @FXML
    private void handleBackAction(ActionEvent event) {
        System.out.println("Navigating back to Financial Intelligence Officer Dashboard...");
    }
}