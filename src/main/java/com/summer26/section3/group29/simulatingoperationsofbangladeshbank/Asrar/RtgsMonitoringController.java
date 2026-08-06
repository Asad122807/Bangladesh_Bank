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

public class RtgsMonitoringController {

    // FXML UI Components
    @FXML private TextField searchBankTextField;
    @FXML private ComboBox<String> statusComboBox;
    @FXML private DatePicker transactionDatePicker;
    @FXML private Button filterButton;
    @FXML private Button refreshButton;

    @FXML private TableView<?> rtgsTableView;
    @FXML private TableColumn<?, ?> txnIdColumn;
    @FXML private TableColumn<?, ?> senderBankColumn;
    @FXML private TableColumn<?, ?> receiverBankColumn;
    @FXML private TableColumn<?, ?> amountColumn;
    @FXML private TableColumn<?, ?> statusColumn;
    @FXML private TableColumn<?, ?> timestampColumn;

    @FXML private Label totalTxnLabel;
    @FXML private Button backButton;

    /**
     * Called automatically by JavaFX when the FXML file is loaded.
     */
    @FXML
    public void initialize() {
        // Populate the Status ComboBox options
        if (statusComboBox != null) {
            statusComboBox.getItems().addAll("All Statuses", "Completed", "Pending", "Failed");
            statusComboBox.getSelectionModel().selectFirst();
        }
    }

    /**
     * Handles the 'Filter' button click event.
     */
    @FXML
    private void handleFilterAction(ActionEvent event) {
        String bankName = searchBankTextField.getText();
        String selectedStatus = statusComboBox.getValue();

        System.out.println("Filtering by Bank: " + bankName);
        System.out.println("Filtering by Status: " + selectedStatus);

        if (transactionDatePicker.getValue() != null) {
            System.out.println("Filtering by Date: " + transactionDatePicker.getValue().toString());
        }

        // TODO: Add code here to filter your table data
    }

    /**
     * Handles the 'Refresh' button click event.
     */
    @FXML
    private void handleRefreshAction(ActionEvent event) {
        System.out.println("Refreshing RTGS transaction records...");

        // Clear search inputs
        searchBankTextField.clear();
        statusComboBox.getSelectionModel().selectFirst();
        transactionDatePicker.setValue(null);

        // TODO: Add code here to reload transaction data into the TableView
    }

    /**
     * Handles the 'Back to Dashboard' button click event.
     */
    @FXML
    private void handleBackAction(ActionEvent event) {
        System.out.println("Navigating back to Payment Systems Officer Dashboard...");

        // TODO: Add scene switching code to return to PaymentSystemsOfficerDashboard.fxml
    }
}