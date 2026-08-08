package com.summer26.section3.group29.simulatingoperationsofbangladeshbank.Asrar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class DowntimeMonitoringController {

    @FXML
    private void handleBackAction(ActionEvent event) {
        try {
            URL dashboardUrl = getClass().getResource("/com/summer26/section3/group29/simulatingoperationsofbangladeshbank/Asrar/PaymentSystemsOfficerDashboard.fxml");
            Parent root = FXMLLoader.load(dashboardUrl);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Payment Systems Officer Dashboard");
            stage.show();
        } catch (IOException e) {
            System.err.println("Error returning to Payment Systems Officer Dashboard.");
            e.printStackTrace();
        }
    }
}