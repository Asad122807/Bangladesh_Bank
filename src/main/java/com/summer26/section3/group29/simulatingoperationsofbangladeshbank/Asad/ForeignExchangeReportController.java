package com.summer26.section3.group29.simulatingoperationsofbangladeshbank.Asad;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ForeignExchangeReportController implements Initializable {

    @FXML
    private ComboBox<String> currencyComboBox;

    @FXML
    private ComboBox<String> transactionTypeComboBox;

    @FXML
    private DatePicker reportDate;

    @FXML
    private TextField amountField;

    @FXML
    private TextArea notesArea;

    public ForeignExchangeReportController() {
        // Explicit public no-arg constructor required by FXMLLoader
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        currencyComboBox.setItems(FXCollections.observableArrayList(
                "USD / BDT",
                "EUR / BDT",
                "GBP / BDT",
                "JPY / BDT",
                "CNY / BDT"
        ));

        transactionTypeComboBox.setItems(FXCollections.observableArrayList(
                "Export Settlement",
                "Import Payment",
                "Remittance Inflow",
                "Interbank Market Operation"
        ));
    }

    @FXML
    void handleClearForm(ActionEvent event) {
        currencyComboBox.getSelectionModel().clearSelection();
        transactionTypeComboBox.getSelectionModel().clearSelection();
        reportDate.setValue(null);
        amountField.clear();
        notesArea.clear();
    }

    @FXML
    void handleSubmitReport(ActionEvent event) {
        String currency = currencyComboBox.getValue();
        String type = transactionTypeComboBox.getValue();
        LocalDate date = reportDate.getValue();
        String amount = amountField.getText().trim();
        String notes = notesArea.getText().trim();

        if (currency == null || type == null || date == null || amount.isEmpty() || notes.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "Please fill in all fields before submitting.");
            return;
        }

        System.out.println("--- Foreign Exchange Report Submitted ---");
        System.out.println("Currency: " + currency);
        System.out.println("Type: " + type);
        System.out.println("Date: " + date);
        System.out.println("Volume: " + amount + " Million");
        System.out.println("Notes: " + notes);

        showAlert(Alert.AlertType.INFORMATION, "Success", "FX Report for " + currency + " submitted successfully.");
        handleClearForm(event);
    }

    @FXML
    void handleBackButton(ActionEvent event) {
        String path = "/com/summer26/section3/group29/simulatingoperationsofbangladeshbank/Asad/DeputyGovernor.fxml";
        URL fxmlUrl = getClass().getResource(path);

        if (fxmlUrl == null) {
            System.err.println("Error: Cannot find DeputyGovernor.fxml at " + path);
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(fxmlUrl);
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Deputy Governor Dashboard");
            stage.show();
        } catch (IOException e) {
            System.err.println("Error returning to Deputy Governor Dashboard:");
            e.printStackTrace();
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}