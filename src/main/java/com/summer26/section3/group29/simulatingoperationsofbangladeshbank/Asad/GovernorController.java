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

public class GovernorController {

    @FXML
    void handleMonetaryPolicy(ActionEvent event) {
        navigateToScreen(event, "MonetaryPolicy.fxml", "Monetary Policy Management");
    }

    @FXML
    void handleForeignReserveReport(ActionEvent event) {
        navigateToScreen(event, "ForeignReserveReport.fxml", "Foreign Exchange Reserve Report");
    }

    @FXML
    void handleLiquiditySupportRequest(ActionEvent event) {
        navigateToScreen(event, "LiquiditySupportRequest.fxml", "Emergency Liquidity Support Request");
    }

    @FXML
    void handleDepartmentTask(ActionEvent event) {
        navigateToScreen(event, "DepartmentTask.fxml", "Department Task Assignment");
    }


    @FXML
    void handleLogout(ActionEvent event) {
        System.out.println("System: Governor logging out...");

        // Navigates back to the root login view (hello-view.fxml)
        String loginPath = "/com/summer26/section3/group29/simulatingoperationsofbangladeshbank/hello-view.fxml";
        URL fxmlUrl = getClass().getResource(loginPath);

        if (fxmlUrl == null) {
            System.err.println("Error: Could not locate login FXML file at: " + loginPath);
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
            System.err.println("Error: Failed to load login screen.");
            e.printStackTrace();
        }
    }


    private void navigateToScreen(ActionEvent event, String fxmlFile, String title) {
        String path = "/com/summer26/section3/group29/simulatingoperationsofbangladeshbank/Asad/" + fxmlFile;
        URL fxmlUrl = getClass().getResource(path);

        if (fxmlUrl == null) {
            System.err.println("Error: Unable to locate FXML at " + path);
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(fxmlUrl);
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle(title);
            stage.show();
        } catch (IOException e) {
            System.err.println("Error loading screen: " + fxmlFile);
            e.printStackTrace();
        }
    }
}