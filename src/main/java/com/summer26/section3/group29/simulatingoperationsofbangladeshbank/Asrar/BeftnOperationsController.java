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

public class BeftnOperationsController {

    @FXML private TextField batchIdTextField;
    @FXML private ComboBox<String> transferTypeComboBox;
    @FXML private DatePicker settlementDatePicker;
    @FXML private Button filterButton;

    @FXML private TableView<?> beftnTableView;
    @FXML private TableColumn<?, ?> batchIdColumn;
    @FXML private TableColumn<?, ?> originatingBankColumn;
    @FXML private TableColumn<?, ?> receivingBankColumn;
    @FXML private TableColumn<?, ?> transferTypeColumn;
    @FXML private TableColumn<?, ?> totalAmountColumn;
    @FXML private TableColumn<?, ?> settlementStatusColumn;

    @FXML private Label totalBatchesLabel;
    @FXML private Button refreshButton;
    @FXML private Button backButton;

    @FXML
    public void initialize() {
        if (transferTypeComboBox != null) {
            transferTypeComboBox.getItems().addAll("All Types", "Credit Transfer", "Debit Transfer");
            transferTypeComboBox.getSelectionModel().selectFirst();
        }
    }

    @FXML
    private void handleFilterAction(ActionEvent event) {
        String batchId = batchIdTextField.getText();
        String selectedType = transferTypeComboBox.getValue();
        System.out.println("Filtering BEFTN - Batch ID: " + batchId + ", Type: " + selectedType);
    }

    @FXML
    private void handleRefreshAction(ActionEvent event) {
        System.out.println("Refreshing BEFTN operations data...");
        batchIdTextField.clear();
        transferTypeComboBox.getSelectionModel().selectFirst();
        settlementDatePicker.setValue(null);
    }

    @FXML
    private void handleBackAction(ActionEvent event) {
        try {
            java.net.URL dashboardUrl = getClass().getResource("/com/summer26/section3/group29/simulatingoperationsofbangladeshbank/Asrar/PaymentSystemsOfficerDashboard.fxml");
            javafx.scene.Parent root = javafx.fxml.FXMLLoader.load(dashboardUrl);
            javafx.stage.Stage stage = (javafx.stage.Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new javafx.scene.Scene(root));
            stage.setTitle("Payment Systems Officer Dashboard");
            stage.show();
        } catch (java.io.IOException e) {
            System.err.println("Error returning to Payment Systems Officer Dashboard.");
            e.printStackTrace();
        }
    }
}