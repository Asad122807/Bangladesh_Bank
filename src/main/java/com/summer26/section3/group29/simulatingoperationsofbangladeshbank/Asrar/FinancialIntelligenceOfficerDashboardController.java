package com.summer26.section3.group29.simulatingoperationsofbangladeshbank.Asrar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class FinancialIntelligenceOfficerDashboardController {

    @FXML private Label welcomeLabel;
    @FXML private Button logoutButton;

    @FXML private Button strButton;
    @FXML private Button amlAlertsButton;
    @FXML private Button fraudReportsButton;
    @FXML private Button investigationCasesButton;
    @FXML private Button riskProfilesButton;

    @FXML private Label pendingStrLabel;
    @FXML private Label criticalAmlLabel;
    @FXML private Label openCasesLabel;
    @FXML private Label statusLabel;


    @FXML
    public void initialize() {
        // Initialize summary stats with sample dummy data
        pendingStrLabel.setText("8 Reports");
        criticalAmlLabel.setText("3 Active");
        openCasesLabel.setText("5 Cases");
    }


    @FXML
    private void handleStrAction(ActionEvent event) {
        System.out.println("Navigating to StrReview.fxml...");
        // TODO: Implement Scene switching code for StrReview.fxml
    }


    @FXML
    private void handleAmlAlertsAction(ActionEvent event) {
        System.out.println("Navigating to AmlAlerts.fxml...");
        // TODO: Implement Scene switching code for AmlAlerts.fxml
    }


    @FXML
    private void handleFraudReportsAction(ActionEvent event) {
        System.out.println("Navigating to FraudReports.fxml...");
        // TODO: Implement Scene switching code for FraudReports.fxml
    }


    @FXML
    private void handleInvestigationCasesAction(ActionEvent event) {
        System.out.println("Navigating to InvestigationCase.fxml...");
        // TODO: Implement Scene switching code for InvestigationCase.fxml
    }


    @FXML
    private void handleRiskProfilesAction(ActionEvent event) {
        System.out.println("Navigating to CustomerRiskProfile.fxml...");
        // TODO: Implement Scene switching code for CustomerRiskProfile.fxml
    }


    @FXML
    private void handleLogoutAction(ActionEvent event) {
        System.out.println("Logging out Financial Intelligence Officer...");
        // TODO: Switch scene back to Login screen
    }
}