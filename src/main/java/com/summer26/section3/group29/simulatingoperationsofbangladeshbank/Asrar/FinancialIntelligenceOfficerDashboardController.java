package com.summer26.section3.group29.simulatingoperationsofbangladeshbank.Asrar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class FinancialIntelligenceOfficerDashboardController {

    @FXML private Button strButton;
    @FXML private Button amlAlertsButton;
    @FXML private Button fraudReportsButton;
    @FXML private Button investigationCasesButton;
    @FXML private Button riskProfilesButton;
    @FXML private Button logoutButton;

    @FXML
    private void handleStrAction(ActionEvent event) {

        switchScene(event, "StrReview.fxml", "Review STR Reports");
    }

    @FXML
    private void handleAmlAlertsAction(ActionEvent event) {

        switchScene(event, "AmlAlerts.fxml", "Investigate AML Alerts");
    }

    @FXML
    private void handleFraudReportsAction(ActionEvent event) {

        switchScene(event, "FraudReports.fxml", "Fraud Detection Reports");
    }

    @FXML
    private void handleInvestigationCasesAction(ActionEvent event) {
        switchScene(event, "InvestigationCase.fxml", "Manage Investigation Cases");
    }

    @FXML
    private void handleRiskProfilesAction(ActionEvent event) {
        switchScene(event, "CustomerRiskProfile.fxml", "Customer Risk Profiles");
    }

    @FXML
    private void handleLogoutAction(ActionEvent event) {
        try {
            String resourcePath = "/com/summer26/section3/group29/simulatingoperationsofbangladeshbank/hello-view.fxml";
            URL loginUrl = getClass().getResource(resourcePath);

            if (loginUrl == null) {
                System.err.println("Could not find hello-view.fxml at: " + resourcePath);
                return;
            }

            Parent root = FXMLLoader.load(loginUrl);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Login");
            stage.show();
        } catch (IOException e) {
            System.err.println("Error loading Login screen.");
            e.printStackTrace();
        }
    }
    private void switchScene(ActionEvent event, String fxmlFile, String title) {
        String resourcePath = "/com/summer26/section3/group29/simulatingoperationsofbangladeshbank/Asrar/" + fxmlFile;
        URL fxmlUrl = getClass().getResource(resourcePath);

        if (fxmlUrl == null) {
            System.err.println("Could not locate FXML file: " + fxmlFile);
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(fxmlUrl);
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle(title);
            stage.show();
        } catch (IOException e) {
            System.err.println("Error loading screen: " + fxmlFile);
            e.printStackTrace();
        }
    }
}