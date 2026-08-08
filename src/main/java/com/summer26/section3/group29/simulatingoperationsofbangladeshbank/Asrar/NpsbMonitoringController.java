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

public class NpsbMonitoringController {

    @FXML private ComboBox<String> channelComboBox;
    @FXML private TextField bankSearchTextField;
    @FXML private DatePicker transactionDatePicker;
    @FXML private Button filterButton;
    @FXML private Button refreshButton;

    @FXML private TableView<?> npsbTableView;
    @FXML private TableColumn<?, ?> txnIdColumn;
    @FXML private TableColumn<?, ?> channelColumn;
    @FXML private TableColumn<?, ?> issuerBankColumn;
    @FXML private TableColumn<?, ?> acquirerBankColumn;
    @FXML private TableColumn<?, ?> amountColumn;
    @FXML private TableColumn<?, ?> statusColumn;

    @FXML private Label totalVolumeLabel;
    @FXML private Button backButton;

    @FXML
    public void initialize() {
        if (channelComboBox != null) {
            channelComboBox.getItems().addAll("All Channels", "ATM", "POS", "Internet Banking", "MFS Interoperability");
            channelComboBox.getSelectionModel().selectFirst();
        }
    }

    @FXML
    private void handleFilterAction(ActionEvent event) {
        String channel = channelComboBox.getValue();
        String bank = bankSearchTextField.getText();
        System.out.println("Filtering NPSB - Channel: " + channel + ", Bank: " + bank);
    }

    @FXML
    private void handleRefreshAction(ActionEvent event) {
        System.out.println("Refreshing NPSB transaction data...");
        channelComboBox.getSelectionModel().selectFirst();
        bankSearchTextField.clear();
        transactionDatePicker.setValue(null);
    }

    @FXML
    private void handleBackAction(ActionEvent event) {
        System.out.println("Navigating back to Payment Systems Officer Dashboard...");
    }
}