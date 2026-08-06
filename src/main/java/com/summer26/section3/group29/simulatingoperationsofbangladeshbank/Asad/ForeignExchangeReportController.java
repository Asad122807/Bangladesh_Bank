package com.summer26.section3.group29.simulatingoperationsofbangladeshbank.Asad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class ForeignExchangeReportController {

    @FXML
    private DatePicker reportDatePicker;

    @FXML
    private ComboBox<String> currencyComboBox;

    @FXML
    private TextField exchangeRateField;

    @FXML
    private TextField remittanceField;

    @FXML
    private TextField tradeBalanceField;

    @FXML
    private TextArea remarksArea;

    @FXML
    public void initialize() {
        currencyComboBox.getItems().addAll("USD", "EUR", "GBP", "JPY", "SAR");
    }

    @FXML
    void handleSubmitReport(ActionEvent event) {
        LocalDate date = reportDatePicker.getValue();
        String currency = currencyComboBox.getValue();
        String rate = exchangeRateField.getText();
        String remittance = remittanceField.getText();
        String tradeBalance = tradeBalanceField.getText();
        String remarks = remarksArea.getText();

        if (date == null || currency == null || rate.isEmpty() || remittance.isEmpty() || tradeBalance.isEmpty() || remarks.trim().isEmpty()) {
            System.out.println("Error: Please fill out all fields before submitting.");
            return;
        }

        System.out.println("--- Foreign Exchange Report Submitted ---");
        System.out.println("Date: " + date);
        System.out.println("Base Currency: " + currency);
        System.out.println("Rate (BDT): " + rate);
        System.out.println("Remittance: " + remittance + " USD Mn");
        System.out.println("Trade Balance: " + tradeBalance + " USD Mn");
        System.out.println("Remarks: " + remarks);
        System.out.println("-----------------------------------------");

        handleClearForm(event);
    }

    @FXML
    void handleClearForm(ActionEvent event) {
        reportDatePicker.setValue(null);
        currencyComboBox.getSelectionModel().clearSelection();
        exchangeRateField.clear();
        remittanceField.clear();
        tradeBalanceField.clear();
        remarksArea.clear();

        System.out.println("System: FX Report form cleared.");
    }

    @FXML
    void handleBackButton(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Governor.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Dashboard");
            stage.show();
        } catch (IOException e) {
            System.out.println("Error: Could not load the destination view.");
            e.printStackTrace();
        }
    }
}