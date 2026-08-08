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

public class FraudReportsController {

    @FXML private TextField fraudIdTextField;
    @FXML private ComboBox<String> categoryComboBox;
    @FXML private DatePicker fraudDatePicker;
    @FXML private Button filterButton;
    @FXML private Button refreshButton;

    @FXML private TableView<?> fraudReportsTableView;
    @FXML private TableColumn<?, ?> fraudIdColumn;
    @FXML private TableColumn<?, ?> bankNameColumn;
    @FXML private TableColumn<?, ?> categoryColumn;
    @FXML private TableColumn<?, ?> amountColumn;
    @FXML private TableColumn<?, ?> statusColumn;
    @FXML private TableColumn<?, ?> dateColumn;

    @FXML private Label totalFraudLabel;
    @FXML private Button reviewButton;
    @FXML private Button backButton;

    @FXML
    public void initialize() {
        if (categoryComboBox != null) {
            categoryComboBox.getItems().addAll("All Categories", "Identity Theft", "Card Fraud", "Wire Fraud", "Unauthorized Access");
            categoryComboBox.getSelectionModel().selectFirst();
        }
    }

    @FXML
    private void handleFilterAction(ActionEvent event) {
        String fraudId = fraudIdTextField.getText();
        String category = categoryComboBox.getValue();
        System.out.println("Filtering Fraud Reports - ID: " + fraudId + ", Category: " + category);
    }

    @FXML
    private void handleRefreshAction(ActionEvent event) {
        System.out.println("Refreshing Fraud Reports data...");
        fraudIdTextField.clear();
        categoryComboBox.getSelectionModel().selectFirst();
        fraudDatePicker.setValue(null);
    }

    @FXML
    private void handleReviewAction(ActionEvent event) {
        System.out.println("Opening selected fraud case for review...");
    }

    @FXML
    private void handleBackAction(ActionEvent event) {
        System.out.println("Navigating back to Financial Intelligence Officer Dashboard...");
    }
}