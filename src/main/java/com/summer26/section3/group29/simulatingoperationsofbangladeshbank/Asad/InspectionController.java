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

public class InspectionController implements Initializable {

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

    public InspectionController() {
        // Explicit public constructor required by JavaFX FXMLLoader
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Populate target commercial bank options
        bankComboBox.setItems(FXCollections.observableArrayList(
                "Sonali Bank PLC",
                "Janata Bank PLC",
                "Agrani Bank PLC",
                "Pubali Bank PLC",
                "BRAC Bank PLC",
                "Dutch-Bangla Bank PLC"
        ));

        // Populate inspection categories
        categoryComboBox.setItems(FXCollections.observableArrayList(
                "Financial Audit",
                "Regulatory Compliance",
                "AML/CFT Verification",
                "Risk Management Assessment",
                "Special Inspection"
        ));
    }


    @FXML
    void handleClearForm(ActionEvent event) {
        bankComboBox.getSelectionModel().clearSelection();
        categoryComboBox.getSelectionModel().clearSelection();
        inspectionDate.setValue(null);
        inspectorField.clear();
        remarksArea.clear();
    }


    @FXML
    void handleSubmitReport(ActionEvent event) {
        String selectedBank = bankComboBox.getValue();
        String selectedCategory = categoryComboBox.getValue();
        LocalDate date = inspectionDate.getValue();
        String inspectorId = inspectorField.getText().trim();
        String remarks = remarksArea.getText().trim();


        if (selectedBank == null || selectedCategory == null || date == null || inspectorId.isEmpty() || remarks.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "Please fill in all fields before submitting the report.");
            return;
        }


        System.out.println("--- Bank Inspection Report Submitted ---");
        System.out.println("Target Bank: " + selectedBank);
        System.out.println("Category: " + selectedCategory);
        System.out.println("Date: " + date);
        System.out.println("Inspector ID: " + inspectorId);
        System.out.println("Remarks: " + remarks);

        showAlert(Alert.AlertType.INFORMATION, "Success", "Inspection report for " + selectedBank + " submitted successfully.");

        handleClearForm(event);
    }


    @FXML
    void handleBackButton(ActionEvent event) {
        String path = "/com/summer26/section3/group29/simulatingoperationsofbangladeshbank/Asad/DeputyGovernor.fxml";
        URL fxmlUrl = getClass().getResource(path);

        if (fxmlUrl == null) {
            System.err.println("Error: Could not find DeputyGovernor.fxml at " + path);
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
            System.err.println("Error navigating back to Deputy Governor Dashboard.");
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