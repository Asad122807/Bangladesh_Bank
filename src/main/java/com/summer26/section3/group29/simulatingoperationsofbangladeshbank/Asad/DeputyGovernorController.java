package com.summer26.section3.group29.simulatingoperationsofbangladeshbank.Asad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class DeputyGovernorController {

    public DeputyGovernorController() {
        // Explicit public no-arg constructor required by FXMLLoader
    }

    @FXML
    void handleCurrencyReport(ActionEvent event) {
        navigateToScreen(event, "CurrencyReport.fxml", "Currency Circulation Report");
    }

    @FXML
    void handleInspection(ActionEvent event) {
        if (!navigateToScreen(event, "ComplianceReport.fxml", "Bank Inspection Report")) {
            navigateToScreen(event, "Inspection.fxml", "Bank Inspection Report");
        }
    }

    @FXML
    void handleForeignExchangeReport(ActionEvent event) {
        navigateToScreen(event, "ForeignExchangeReport.fxml", "Foreign Exchange Report");
    }

    @FXML
    void handleLogout(ActionEvent event) {
        System.out.println("System: Deputy Governor logging out...");

        String loginPath = "/com/summer26/section3/group29/simulatingoperationsofbangladeshbank/hello-view.fxml";
        URL fxmlUrl = getClass().getResource(loginPath);

        if (fxmlUrl == null) {
            loginPath = "/com/summer26/section3/group29/simulatingoperationsofbangladeshbank/Login.fxml";
            fxmlUrl = getClass().getResource(loginPath);
        }

        if (fxmlUrl == null) {
            System.err.println("Error: Could not locate login FXML file in resources.");
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(fxmlUrl);
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Login");
            stage.show();
        } catch (IOException e) {
            System.err.println("Error loading login screen:");
            e.printStackTrace();
        }
    }

    private boolean navigateToScreen(ActionEvent event, String fxmlFile, String title) {
        String path = "/com/summer26/section3/group29/simulatingoperationsofbangladeshbank/Asad/" + fxmlFile;
        URL fxmlUrl = getClass().getResource(path);

        if (fxmlUrl == null) {
            System.err.println("Notice: Resource not found at " + path);
            return false;
        }

        try {
            FXMLLoader loader = new FXMLLoader(fxmlUrl);
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle(title);
            stage.show();
            return true;
        } catch (IOException e) {
            System.err.println("Error loading screen: " + fxmlFile);
            e.printStackTrace();
            return false;
        }
    }
}