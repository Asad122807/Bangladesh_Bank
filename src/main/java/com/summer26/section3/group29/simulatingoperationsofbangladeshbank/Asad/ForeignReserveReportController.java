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

public class ForeignReserveReportController {



    @FXML
    private TextField reportIdField;

    @FXML
    private TextField totalReserveField;

    @FXML
    private TextField goldReserveField;

    @FXML
    private TextField foreignCurrencyField;

    @FXML
    private TextField importCoverField;


    @FXML
    void handleLoadReport(ActionEvent event) {
        // Mock data population simulating system/database retrieval
        String reportId = "FR-2026-08";
        double totalReserves = 31.85;      // USD Bn
        double goldReserves = 2.10;        // USD Bn
        double foreignCurrency = 29.75;    // USD Bn
        double importCover = 5.1;          // Months

        // Display retrieved values in fields
        reportIdField.setText(reportId);
        totalReserveField.setText(String.valueOf(totalReserves));
        goldReserveField.setText(String.valueOf(goldReserves));
        foreignCurrencyField.setText(String.valueOf(foreignCurrency));
        importCoverField.setText(String.valueOf(importCover));

        System.out.println("System: Foreign Reserve data loaded.");
    }

    @FXML
    void handleAcknowledgeReport(ActionEvent event) {
        // Verify data has been loaded prior to saving
        if (reportIdField.getText().isEmpty()) {
            System.out.println("Error: Please load the report data before attempting to save.");
            return;
        }

        System.out.println("Success: Foreign Reserve Report (" + reportIdField.getText() + ") saved successfully.");

        // Reset form fields following a successful save
        clearFields();
    }


    @FXML
    void handleBackButton(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Governor.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Governor Dashboard");
            stage.show();

        } catch (IOException e) {
            System.out.println("Error: Unable to load Governor.fxml. Ensure the file name and directory location are correct.");
            e.printStackTrace();
        }
    }


    private void clearFields() {
        reportIdField.clear();
        totalReserveField.clear();
        goldReserveField.clear();
        foreignCurrencyField.clear();
        importCoverField.clear();
    }
}