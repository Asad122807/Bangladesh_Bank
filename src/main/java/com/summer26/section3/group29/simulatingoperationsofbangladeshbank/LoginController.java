package com.summer26.section3.group29.simulatingoperationsofbangladeshbank;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LoginController {

    @FXML
    private TextField idField;

    @FXML
    private PasswordField passwordField;

    @FXML
    void loginbutton(ActionEvent event) {
        if (idField == null || passwordField == null) {
            System.err.println("Error: UI components not linked. Check fx:id in FXML.");
            return;
        }

        String id = idField.getText().trim();
        String password = passwordField.getText().trim();

        // Debug prints to verify what input JavaFX receives
        System.out.println("Attempting login -> ID: '" + id + "', Password: '" + password + "'");

        // Role-based login logic
        if (id.equals("1234") && password.equals("1234")) {
            System.out.println("Success: Logging in as Governor...");
            switchScene(event, "Governor.fxml", "Governor Dashboard");
        } else if (id.equals("5678") && password.equals("5678")) {
            System.out.println("Success: Logging in as Deputy Governor...");
            switchScene(event, "DeputyGovernor.fxml", "Deputy Governor Dashboard");
        } else {
            System.out.println("Error: Invalid Credentials.");
        }
    }

    private void switchScene(ActionEvent event, String fxmlFile, String title) {
        String resourcePath = "/com/summer26/section3.group29.simulatingoperationsofbangladeshbank/Asad/" + fxmlFile;
        URL fxmlUrl = getClass().getResource(resourcePath);

        // Fallback check if path uses slashes instead of dots
        if (fxmlUrl == null) {
            resourcePath = "/com/summer26/section3/group29/simulatingoperationsofbangladeshbank/Asad/" + fxmlFile;
            fxmlUrl = getClass().getResource(resourcePath);
        }

        if (fxmlUrl == null) {
            System.err.println("Error: Could not locate FXML file: " + fxmlFile);
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