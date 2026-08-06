package com.summer26.section3.group29.simulatingoperationsofbangladeshbank.Asad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CurrencyReportController {


    @FXML private TextField reportIdField;
    @FXML private TextField currencyIssueField;
    @FXML private TextField damagedNotesField;
    @FXML private TextField vaultBalanceField;
    @FXML private TextField cashDemandField;


    private int reportId;
    private double currencyIssue;
    private double damagedNotes;
    private double vaultBalance;
    private String cashDemand;


    @FXML
    void handleLoadReport(ActionEvent event) {
        // 1. Fetching/Setting the exact data types in the backend
        reportId = 1045;
        currencyIssue = 500.50;
        damagedNotes = 12.75;
        vaultBalance = 150.20;
        cashDemand = "HIGH";

        // 2. Displaying the variables in the JavaFX TextFields
        reportIdField.setText(String.valueOf(reportId));
        currencyIssueField.setText(String.valueOf(currencyIssue));
        damagedNotesField.setText(String.valueOf(damagedNotes));
        vaultBalanceField.setText(String.valueOf(vaultBalance));
        cashDemandField.setText(cashDemand);

        System.out.println("System: Currency report data loaded successfully.");
    }
    @FXML
    void handleUpdateSchedule(ActionEvent event) {

        if (reportIdField.getText().isEmpty()) {
            System.out.println("Error: Please load the report data first.");
            return;
        }

        System.out.println("Success: Cash supply schedule updated for Report ID: " + reportId);
        System.out.println("Action: Regional offices notified regarding " + cashDemand + " cash demand.");

        // Clear the form fields after updating
        reportIdField.clear();
        currencyIssueField.clear();
        damagedNotesField.clear();
        vaultBalanceField.clear();
        cashDemandField.clear();
    }


    @FXML
    void handleBackButton(ActionEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("DeputyGovernor.fxml"));
            Parent root = loader.load();


            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();


            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Deputy Governor Dashboard");
            stage.show();

        } catch (IOException e) {
            System.out.println("Error: Could not load the dashboard view.");
            e.printStackTrace();
        }
    }
}