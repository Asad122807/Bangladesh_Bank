package com.summer26.section3.group29.simulatingoperationsofbangladeshbank.Asad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class MonetaryPolicyController {



    @FXML
    private TextField inflationRateField;

    @FXML
    private TextField gdpGrowthField;

    @FXML
    private TextField repoRateField;

    @FXML
    private TextField reverseRepoField;

    @FXML
    private TextArea justificationArea;


    @FXML
    void handleLoadIndicators(ActionEvent event) {
        // Simulating fetching current economic data from the system
        double currentInflation = 9.5; // Example percentage
        double currentGdpGrowth = 6.2; // Example percentage

        // Set the fetched data to the read-only fields
        inflationRateField.setText(String.valueOf(currentInflation));
        gdpGrowthField.setText(String.valueOf(currentGdpGrowth));

        System.out.println("System: Economic indicators loaded successfully.");
    }


    @FXML
    void handleUpdatePolicy(ActionEvent event) {
        String repoRateStr = repoRateField.getText();
        String reverseRepoStr = reverseRepoField.getText();
        String justification = justificationArea.getText();


        if (repoRateStr.isEmpty() || reverseRepoStr.isEmpty() || justification.isEmpty()) {
            System.out.println("Error: Please enter the new Repo Rate, Reverse Repo Rate, and Justification.");
            return;
        }

        try {

            double newRepo = Double.parseDouble(repoRateStr);
            double newReverseRepo = Double.parseDouble(reverseRepoStr);


            System.out.println("Success: Monetary Policy updated.");
            System.out.println("- New Repo Rate: " + newRepo + "%");
            System.out.println("- New Reverse Repo Rate: " + newReverseRepo + "%");
            System.out.println("- Justification: " + justification);


            repoRateField.clear();
            reverseRepoField.clear();
            justificationArea.clear();

        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter valid numeric values for the policy rates.");
        }
    }


    @FXML
    void handleBackButton(ActionEvent event) {
        try {
            // Load the destination FXML (Update "Governor.fxml" if your dashboard name is different)
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Governor.fxml"));
            Parent root = loader.load();


            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();


            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Dashboard");
            stage.show();

        } catch (IOException e) {
            System.out.println("Error: Could not load the dashboard view.");
            e.printStackTrace();
        }
    }
}