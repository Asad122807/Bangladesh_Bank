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

public class PaymentSystemsOfficerDashboardController {

    @FXML private Button rtgsButton;
    @FXML private Button beftnButton;
    @FXML private Button npsbButton;
    @FXML private Button discrepancyButton;
    @FXML private Button downtimeButton;
    @FXML private Button logoutButton;

    @FXML
    private void handleRtgsAction(ActionEvent event) {
        switchScene(event, "RTGS.fxml", "RTGS Transaction Monitoring");
    }

    @FXML
    private void handleBeftnAction(ActionEvent event) {
        switchScene(event, "BEFTN.fxml", "BEFTN Operations Monitoring");
    }

    @FXML
    private void handleNpsbAction(ActionEvent event) {
        switchScene(event, "NPSB.fxml", "NPSB Transaction Monitoring");
    }

    @FXML
    private void handleDiscrepancyAction(ActionEvent event) {
        // Matches DisputeResolution.fxml in resources/Asrar/
        switchScene(event, "DisputeResolution.fxml", "Discrepancy Resolution");
    }

    @FXML
    private void handleDowntimeAction(ActionEvent event) {
        // Matches DowntimeMonitoring.fxml in resources/Asrar/
        switchScene(event, "DowntimeMonitoring.fxml", "Downtime Monitoring");
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