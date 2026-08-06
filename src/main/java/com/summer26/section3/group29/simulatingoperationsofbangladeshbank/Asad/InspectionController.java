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

public class InspectionController {



    @FXML
    private ComboBox<String> bankComboBox;

    @FXML
    private ComboBox<String> categoryComboBox;

    @FXML
    private DatePicker inspectionDate;

    @FXML
    private TextField inspectorField;

    @FXML
    private TextArea remarksArea;


    @FXML
    public void initialize() {

        bankComboBox.getItems().addAll(
                "Sonali Bank",
                "Janata Bank",
                "Agrani Bank",
                "Rupali Bank",
                "BRAC Bank",
                "City Bank",
                "Islami Bank"
        );


        categoryComboBox.getItems().addAll(
                "Compliance Audit",
                "Financial Health",
                "Risk Management",
                "Cybersecurity",
                "Anti-Money Laundering (AML)"
        );
    }


    @FXML
    void handleSubmitReport(ActionEvent event) {
        String bank = bankComboBox.getValue();
        String category = categoryComboBox.getValue();
        LocalDate date = inspectionDate.getValue();
        String inspector = inspectorField.getText();
        String remarks = remarksArea.getText();


        if (bank == null || category == null || date == null || inspector.trim().isEmpty() || remarks.trim().isEmpty()) {
            System.out.println("Error: Please fill out all fields before submitting the inspection report.");
            return;
        }


        System.out.println("--- Inspection Report Submitted ---");
        System.out.println("Target Bank: " + bank);
        System.out.println("Category: " + category);
        System.out.println("Date: " + date);
        System.out.println("Inspector ID: " + inspector);
        System.out.println("Remarks: " + remarks);
        System.out.println("-----------------------------------");


        handleClearForm(event);
    }


    @FXML
    void handleClearForm(ActionEvent event) {
        bankComboBox.getSelectionModel().clearSelection();
        categoryComboBox.getSelectionModel().clearSelection();
        inspectionDate.setValue(null);
        inspectorField.clear();
        remarksArea.clear();

        System.out.println("System: Inspection form cleared.");
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
            System.out.println("Error: Could not load the previous screen.");
            e.printStackTrace();
        }
    }
}