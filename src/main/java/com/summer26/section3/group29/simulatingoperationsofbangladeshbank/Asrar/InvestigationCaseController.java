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

public class InvestigationCaseController {

    @FXML private TextField caseIdTextField;
    @FXML private ComboBox<String> statusComboBox;
    @FXML private DatePicker caseDatePicker;
    @FXML private Button filterButton;
    @FXML private Button refreshButton;

    @FXML private TableView<?> investigationCasesTableView;
    @FXML private TableColumn<?, ?> caseIdColumn;
    @FXML private TableColumn<?, ?> caseTitleColumn;
    @FXML private TableColumn<?, ?> assignedOfficerColumn;
    @FXML private TableColumn<?, ?> priorityColumn;
    @FXML private TableColumn<?, ?> statusColumn;
    @FXML private TableColumn<?, ?> dateOpenedColumn;

    @FXML private Label totalCasesLabel;
    @FXML private Button openDetailsButton;
    @FXML private Button backButton;

    @FXML
    public void initialize() {
        if (statusComboBox != null) {
            statusComboBox.getItems().addAll("All Statuses", "Under Review", "Pending Evidence", "Closed", "Escalated");
            statusComboBox.getSelectionModel().selectFirst();
        }
    }

    @FXML
    private void handleFilterAction(ActionEvent event) {
        String caseId = caseIdTextField.getText();
        String status = statusComboBox.getValue();
        System.out.println("Filtering Investigation Cases - Case ID: " + caseId + ", Status: " + status);
    }

    @FXML
    private void handleRefreshAction(ActionEvent event) {
        System.out.println("Refreshing Investigation Cases data...");
        caseIdTextField.clear();
        statusComboBox.getSelectionModel().selectFirst();
        caseDatePicker.setValue(null);
    }

    @FXML
    private void handleOpenDetailsAction(ActionEvent event) {
        System.out.println("Opening selected investigation case details...");
    }

    @FXML
    private void handleBackAction(ActionEvent event) {
        try {
            java.net.URL dashboardUrl = getClass().getResource("/com/summer26/section3/group29/simulatingoperationsofbangladeshbank/Asrar/FinancialIntelligenceOfficerDashboard.fxml");
            javafx.scene.Parent root = javafx.fxml.FXMLLoader.load(dashboardUrl);
            javafx.stage.Stage stage = (javafx.stage.Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new javafx.scene.Scene(root));
            stage.setTitle("Financial Intelligence Officer Dashboard");
            stage.show();
        } catch (java.io.IOException e) {
            System.err.println("Error returning to Financial Intelligence Officer Dashboard.");
            e.printStackTrace();
        }
    }
}