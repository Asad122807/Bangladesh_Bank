package com.summer26.section3.group29.simulatingoperationsofbangladeshbank.Asrar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PaymentSystemsOfficerDashboardController {

    @FXML private Label welcomeLabel;
    @FXML private Button logoutButton;

    @FXML private Button rtgsButton;
    @FXML private Button beftnButton;
    @FXML private Button npsbButton;
    @FXML private Button discrepancyButton;

    @FXML private Label rtgsVolumeLabel;
    @FXML private Label beftnBatchesLabel;
    @FXML private Label discrepancyCountLabel;
    @FXML private Label statusLabel;

    /**
     * Called automatically by JavaFX when the view initializes.
     */
    @FXML
    public void initialize() {
        // Initialize dashboard state or load summary stats
        rtgsVolumeLabel.setText("BDT 45,200,000");
        beftnBatchesLabel.setText("12 Batches");
        discrepancyCountLabel.setText("2 Pending");
    }

    /**
     * Handles navigation to RTGS Monitoring.
     */
    @FXML
    private void handleRtgsAction(ActionEvent event) {
        System.out.println("Navigating to RTGS.fxml...");
        // TODO: Implement Scene switching code for RTGS.fxml
    }

    /**
     * Handles navigation to BEFTN Operations.
     */
    @FXML
    private void handleBeftnAction(ActionEvent event) {
        System.out.println("Navigating to BEFTN.fxml...");
        // TODO: Implement Scene switching code for BEFTN.fxml
    }

    /**
     * Handles navigation to NPSB Transactions.
     */
    @FXML
    private void handleNpsbAction(ActionEvent event) {
        System.out.println("Navigating to NPSB.fxml...");
        // TODO: Implement Scene switching code for NPSB.fxml
    }

    /**
     * Handles navigation to Settlement Discrepancy Resolution.
     */
    @FXML
    private void handleDiscrepancyAction(ActionEvent event) {
        System.out.println("Navigating to Discrepancy Resolution screen...");
        // TODO: Implement Scene switching code for Discrepancy view
    }

    /**
     * Handles user logout.
     */
    @FXML
    private void handleLogoutAction(ActionEvent event) {
        System.out.println("Logging out Payment Systems Officer...");
        // TODO: Switch scene back to Login screen
    }
}