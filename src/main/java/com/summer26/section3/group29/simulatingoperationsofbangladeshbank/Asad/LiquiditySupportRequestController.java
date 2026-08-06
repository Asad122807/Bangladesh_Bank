package com.summer26.section3.group29.simulatingoperationsofbangladeshbank.Asad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class LiquiditySupportRequestController {


    @FXML
    private ComboBox<String> bankComboBox;


    @FXML
    private TextArea dataDisplayArea;


    @FXML
    public void initialize() {
        bankComboBox.getItems().addAll(
                "Dhaka Bank - Request ID: 001",
                "City Bank - Request ID: 002",
                "BRAC Bank - Request ID: 003"
        );
    }


    @FXML
    void handleFetchData(ActionEvent event) {
        String selectedBank = bankComboBox.getValue();

        if (selectedBank == null) {
            System.out.println("Error: Please select a bank from the dropdown first.");
            return;
        }


        String dummyData = "--- " + selectedBank + " Details ---\n"
                + "Liquidity Ratio: 12.5% (Warning limit is 15%)\n"
                + "Capital Adequacy: Below standard\n"
                + "Deposit Withdrawal Pressure: HIGH\n"
                + "Previous Support History: Supported in 2024 for 500M BDT.";

        dataDisplayArea.setText(dummyData);
        System.out.println("Data fetched successfully for " + selectedBank);
    }


    @FXML
    void handleApprove(ActionEvent event) {

        if (dataDisplayArea.getText().isEmpty()) {
            System.out.println("Error: Cannot approve without fetching and reviewing data first!");
            return;
        }

        System.out.println("Success: Liquidity Support Approved for selected bank.");


        dataDisplayArea.clear();
        bankComboBox.getSelectionModel().clearSelection();
    }

    @FXML
    void handleReject(ActionEvent event) {

        if (dataDisplayArea.getText().isEmpty()) {
            System.out.println("Error: Cannot reject without fetching and reviewing data first!");
            return;
        }

        System.out.println("Action: Liquidity Support Request Rejected.");


        dataDisplayArea.clear();
        bankComboBox.getSelectionModel().clearSelection();
    }


    @FXML
    void handleBackButton(ActionEvent event) {
        try {

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