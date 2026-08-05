package com.summer26.section3.group29.simulatingoperationsofbangladeshbank.Adnan;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CurrencyReportController {

    // FXML UI Components
    @FXML private TextField reportIdField;
    @FXML private TextField currencyIssueField;
    @FXML private TextField damagedNotesField;
    @FXML private TextField vaultBalanceField;
    @FXML private TextField cashDemandField;

    // The specific data variables and types you requested
    private int reportId;
    private double currencyIssue;
    private double damagedNotes;
    private double vaultBalance;
    private String cashDemand; // Assuming String based on typical demand descriptors (e.g., "HIGH")

    /**
     * Triggered when the "Load Report Data" button is clicked.
     */
    @FXML
    void handleLoadReport(ActionEvent event) {
        // 1. Fetching/Setting the exact data types in the backend (Event-4)
        reportId = 1045;
        currencyIssue = 500.50;  // in millions/billions
        damagedNotes = 12.75;    // in millions/billions
        vaultBalance = 150.20;   // in millions/billions
        cashDemand = "HIGH";

        // 2. Displaying the variables in the JavaFX TextFields
        // (Note: JavaFX text fields require Strings, so we use String.valueOf to convert the ints/doubles)
        reportIdField.setText(String.valueOf(reportId));
        currencyIssueField.setText(String.valueOf(currencyIssue));
        damagedNotesField.setText(String.valueOf(damagedNotes));
        vaultBalanceField.setText(String.valueOf(vaultBalance));
        cashDemandField.setText(cashDemand);

        System.out.println("System: Currency report data fetched successfully.");
    }

    /**
     * Triggered when the "Update Schedule & Notify Offices" button is clicked.
     */
    @FXML
    void handleUpdateSchedule(ActionEvent event) {
        // Validation check to ensure data is loaded before proceeding
        if (reportIdField.getText().isEmpty()) {
            System.out.println("Error: Please load the report data first.");
            return;
        }

        // Event-6: System updates cash supply schedule and notifies regional offices
        System.out.println("Success: Cash supply schedule updated for Report ID: " + reportId);
        System.out.println("Action: Regional offices notified regarding " + cashDemand + " cash demand.");

        // Clear the form fields to prepare for the next report
        reportIdField.clear();
        currencyIssueField.clear();
        damagedNotesField.clear();
        vaultBalanceField.clear();
        cashDemandField.clear();
    }
}