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

public class CustomerRiskProfileController {

    @FXML private TextField customerIdTextField;
    @FXML private ComboBox<String> riskCategoryComboBox;
    @FXML private DatePicker profileDatePicker;
    @FXML private Button filterButton;
    @FXML private Button refreshButton;

    @FXML private TableView<?> riskProfilesTableView;
    @FXML private TableColumn<?, ?> customerIdColumn;
    @FXML private TableColumn<?, ?> customerNameColumn;
    @FXML private TableColumn<?, ?> bankNameColumn;
    @FXML private TableColumn<?, ?> riskRatingColumn;
    @FXML private TableColumn<?, ?> kycStatusColumn;
    @FXML private TableColumn<?, ?> lastUpdatedColumn;

    @FXML private Label totalProfilesLabel;
    @FXML private Button viewProfileButton;
    @FXML private Button backButton;

    @FXML
    public void initialize() {
        if (riskCategoryComboBox != null) {
            riskCategoryComboBox.getItems().addAll("All Categories", "High Risk", "Medium Risk", "Low Risk", "PEP (Politically Exposed)");
            riskCategoryComboBox.getSelectionModel().selectFirst();
        }
    }

    @FXML
    private void handleFilterAction(ActionEvent event) {
        String customerId = customerIdTextField.getText();
        String riskCategory = riskCategoryComboBox.getValue();
        System.out.println("Filtering Customer Risk Profiles - ID: " + customerId + ", Category: " + riskCategory);
    }

    @FXML
    private void handleRefreshAction(ActionEvent event) {
        System.out.println("Refreshing Customer Risk Profile data...");
        customerIdTextField.clear();
        riskCategoryComboBox.getSelectionModel().selectFirst();
        profileDatePicker.setValue(null);
    }

    @FXML
    private void handleViewProfileAction(ActionEvent event) {
        System.out.println("Opening selected customer risk profile...");
    }

    @FXML
    private void handleBackAction(ActionEvent event) {
        System.out.println("Navigating back to Financial Intelligence Officer Dashboard...");
    }
}