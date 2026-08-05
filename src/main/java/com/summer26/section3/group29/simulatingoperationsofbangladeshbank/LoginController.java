package com.summer26.section3.group29.simulatingoperationsofbangladeshbank;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import java.io.IOException;

public class LoginController {

    // Matches the fx:id="textfield" in your FXML
    @FXML
    private TextField textfield;

    // Matches the fx:id="passwordf" in your FXML
    @FXML
    private PasswordField passwordf;

    // Matches the fx:id="loginb" in your FXML
    @FXML
    private Button loginb;
    @FXML
    private Text textfield1;
    @FXML
    private Text textfield11;

    // This method is triggered when the "log in" button is clicked
    @FXML
    void loginbutton(ActionEvent event) {
        // 1. Get the text inputted by the user
        String id = textfield.getText();
        String password = passwordf.getText();

        // 2. Validate the ID (Based on your PDF: must be 4 or 7 digits)
        if (!id.matches("\\d{4}") && !id.matches("\\d{7}")) {
            showAlert(Alert.AlertType.WARNING, "Invalid ID", "Please enter a valid 4 or 7 digit ID.");
            return;
        }

        // 3. Check credentials and switch scenes
        try {
            // --- REPLACE these dummy credentials with your actual logic ---
            if (id.equals("1234") && password.equals("12345")) {

                // Example: Switching to the Governor scene in the Adnan folder
                switchScene(event, "Adnan/Governor.fxml", "Governor Dashboard");

            } else if (id.equals("2345") && password.equals("12345")) {

                // Example: Switching to the Deputy Governor scene
                switchScene(event, "Adnan/DeputyGovernor.fxml", "Deputy Governor Dashboard");

            } else {
                showAlert(Alert.AlertType.ERROR, "Login Failed", "Incorrect ID or Password.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Loading Error", "Could not load the next scene.");
        }
    }

    /**
     * Helper method to switch scenes.
     */
    private void switchScene(ActionEvent event, String fxmlFileName, String title) throws IOException {
        // Load the new FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName));
        Parent root = loader.load();

        // Get the current window (stage) from the button click event
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Set the new scene
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }

    /**
     * Helper method to show pop-up alerts.
     */
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}