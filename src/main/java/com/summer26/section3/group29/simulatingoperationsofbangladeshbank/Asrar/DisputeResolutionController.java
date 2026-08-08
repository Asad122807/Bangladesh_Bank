package com.summer26.section3.group29.simulatingoperationsofbangladeshbank.Asrar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class DisputeResolutionController {

    @FXML private TextField searchDisputeTextField;
    @FXML private ComboBox<String> statusComboBox;
    @FXML private Button filterButton;
    @FXML private Button refreshButton;

    @FXML private TableView<?> disputesTableView;
    @FXML private TableColumn<?, ?> disputeIdColumn;
    @FXML private TableColumn<?, ?> txnIdColumn;
    @FXML private TableColumn<?, ?> complainantBankColumn;
    @FXML private TableColumn<?, ?> respondentBankColumn;
    @FXML private TableColumn<?, ?> amountColumn;
    @FXML private TableColumn<?, ?> disputeStatusColumn;

    @FXML private TextField resolutionNoteTextField;
    @FXML private Button resolveDisputeButton;
    @FXML private Button rejectDisputeButton;

    @FXML private Label statusMessageLabel;
    @FXML private Button backButton;

    @FXML
    public void initialize() {
        if (statusComboBox != null) {
            statusComboBox.getItems().addAll("All Statuses", "Pending Investigation", "Resolved", "Rejected");
            statusComboBox.getSelectionModel().selectFirst();
        }
    }

    @FXML
    private void handleFilterAction(ActionEvent event) {
        String query = searchDisputeTextField.getText();
        String status = statusComboBox.getValue();
        System.out.println("Filtering disputes - Query: " + query + ", Status: " + status);
    }

    @FXML
    private void handleRefreshAction(ActionEvent event) {
        System.out.println("Refreshing disputes list...");
        searchDisputeTextField.clear();
        statusComboBox.getSelectionModel().selectFirst();
    }

    @FXML
    private void handleResolveDisputeAction(ActionEvent event) {
        String note = resolutionNoteTextField.getText();
        System.out.println("Resolving dispute with note: " + note);
        statusMessageLabel.setText("Dispute marked as Resolved!");
    }

    @FXML
    private void handleRejectDisputeAction(ActionEvent event) {
        String note = resolutionNoteTextField.getText();
        System.out.println("Rejecting dispute with note: " + note);
        statusMessageLabel.setText("Dispute marked as Rejected!");
    }

    @FXML
    private void handleBackAction(ActionEvent event) {
        System.out.println("Navigating back to Payment Systems Officer Dashboard...");
    }
}