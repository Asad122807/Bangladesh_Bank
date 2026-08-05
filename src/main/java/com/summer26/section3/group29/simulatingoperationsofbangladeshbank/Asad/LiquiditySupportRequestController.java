package com.summer26.section3.group29.simulatingoperationsofbangladeshbank.Asad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class LiquiditySupportRequestController {

    // Matches the fx:id="bankComboBox" in your FXML
    @FXML
    private ComboBox<String> bankComboBox;

    // Matches the fx:id="dataDisplayArea" in your FXML
    @FXML
    private TextArea dataDisplayArea;

    /**
     * This method runs automatically when the scene is loaded.
     * It populates the ComboBox with pending bank requests.
     */
    @FXML
    public void initialize() {
        // Event-4: System displays pending requests from commercial banks[cite: 1]
        bankComboBox.getItems().addAll(
                "Dhaka Bank - Request ID: 001",
                "City Bank - Request ID: 002",
                "BRAC Bank - Request ID: 003"
        );
    }

    /**
     * Triggered when the "Fetch Data" button is clicked.
     */
    @FXML
    void handleFetchData(ActionEvent event) {
        // Event-5: Governor selects a specific bank request[cite: 1]
        String selectedBank = bankComboBox.getValue();

        if (selectedBank == null) {
            System.out.println("Error: Please select a bank from the dropdown first.");
            return;
        }

        // Event-6: System fetches bank liquidity ratio, capital adequacy, deposit withdrawal pressure, and previous support history[cite: 1]
        String dummyData = "--- " + selectedBank + " Details ---\n"
                + "Liquidity Ratio: 12.5% (Warning limit is 15%)\n"
                + "Capital Adequacy: Below standard\n"
                + "Deposit Withdrawal Pressure: HIGH\n"
                + "Previous Support History: Supported in 2024 for 500M BDT.";

        dataDisplayArea.setText(dummyData);
        System.out.println("Data fetched successfully for " + selectedBank);
    }

    /**
     * Triggered when the "Approve" button is clicked.
     */
    @FXML
    void handleApprove(ActionEvent event) {
        // Validation check to ensure data was fetched before approving
        if (dataDisplayArea.getText().isEmpty()) {
            System.out.println("Error: Cannot approve without fetching and reviewing data first!");
            return;
        }

        System.out.println("Success: Liquidity Support Approved for selected bank.");

        // Clear the screen to prepare for the next request
        dataDisplayArea.clear();
        bankComboBox.getSelectionModel().clearSelection();
    }

    /**
     * Triggered when the "Reject" button is clicked.
     */
    @FXML
    void handleReject(ActionEvent event) {
        // Validation check to ensure data was fetched before rejecting
        if (dataDisplayArea.getText().isEmpty()) {
            System.out.println("Error: Cannot reject without fetching and reviewing data first!");
            return;
        }

        System.out.println("Action: Liquidity Support Request Rejected.");

        // Clear the screen to prepare for the next request
        dataDisplayArea.clear();
        bankComboBox.getSelectionModel().clearSelection();
    }
}