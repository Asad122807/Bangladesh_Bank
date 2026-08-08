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

    @FXML
    public void initialize() {
        if (statusComboBox != null) {
            statusComboBox.getItems().addAll("All Statuses", "Completed", "Pending", "Failed");
            statusComboBox.getSelectionModel().selectFirst();
        }
    }

    @FXML
    private void handleFilterAction(ActionEvent event) {
        String bank = searchBankTextField.getText();
        String status = statusComboBox.getValue();
        System.out.println("Filtering RTGS Transactions - Bank: " + bank + ", Status: " + status);
    }

    @FXML
    private void handleRefreshAction(ActionEvent event) {
        System.out.println("Refreshing RTGS data...");
        searchBankTextField.clear();
        statusComboBox.getSelectionModel().selectFirst();
        transactionDatePicker.setValue(null);
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