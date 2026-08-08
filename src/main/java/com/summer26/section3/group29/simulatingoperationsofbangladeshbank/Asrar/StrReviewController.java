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

public class StrReviewController {

    @FXML private TextField searchBankTextField;
    @FXML private ComboBox<String> riskLevelComboBox;
    @FXML private DatePicker reportDatePicker;
    @FXML private Button filterButton;
    @FXML private Button refreshButton;

    @FXML private TableView<?> strTableView;
    @FXML private TableColumn<?, ?> reportIdColumn;
    @FXML private TableColumn<?, ?> reportingBankColumn;
    @FXML private TableColumn<?, ?> customerNameColumn;
    @FXML private TableColumn<?, ?> suspicionTypeColumn;
    @FXML private TableColumn<?, ?> riskLevelColumn;
    @FXML private TableColumn<?, ?> dateReportedColumn;

    @FXML private Label totalReportsLabel;
    @FXML private Button viewDetailsButton;
    @FXML private Button backButton;

    @FXML
    public void initialize() {
        if (riskLevelComboBox != null) {
            riskLevelComboBox.getItems().addAll("All Risks", "High", "Medium", "Low");
            riskLevelComboBox.getSelectionModel().selectFirst();
        }
    }

    @FXML
    private void handleFilterAction(ActionEvent event) {
        String bank = searchBankTextField.getText();
        String risk = riskLevelComboBox.getValue();
        System.out.println("Filtering STR - Bank: " + bank + ", Risk: " + risk);
    }

    @FXML
    private void handleRefreshAction(ActionEvent event) {
        System.out.println("Refreshing STR data...");
        searchBankTextField.clear();
        riskLevelComboBox.getSelectionModel().selectFirst();
        reportDatePicker.setValue(null);
    }

    @FXML
    private void handleViewDetailsAction(ActionEvent event) {
        System.out.println("Viewing details for the selected STR...");
        // TODO: Get selected row from TableView and show details in a new window/alert
    }

    @FXML
    private void handleBackAction(ActionEvent event) {
        System.out.println("Navigating back to Financial Intelligence Officer Dashboard...");
    }
}