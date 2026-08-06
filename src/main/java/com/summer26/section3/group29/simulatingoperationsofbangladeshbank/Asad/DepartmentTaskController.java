package com.summer26.section3.group29.simulatingoperationsofbangladeshbank.Asad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class DepartmentTaskController {



    @FXML
    private TextField taskIdField;

    @FXML
    private ComboBox<String> departmentComboBox;

    @FXML
    private TextField taskTitleField;

    @FXML
    private DatePicker deadlinePicker;

    @FXML
    private TextArea taskDescriptionArea;


    @FXML
    public void initialize() {
        departmentComboBox.getItems().addAll(
                "Currency Management",
                "Banking Regulation",
                "Foreign Exchange",
                "IT & Cybersecurity",
                "Research & Statistics"
        );
    }

    @FXML
    void handleAssignTask(ActionEvent event) {
        String taskId = taskIdField.getText();
        String title = taskTitleField.getText();
        String department = departmentComboBox.getValue();
        LocalDate deadline = deadlinePicker.getValue();
        String description = taskDescriptionArea.getText();


        if (taskId.isEmpty() || title.isEmpty() || department == null || deadline == null || description.isEmpty()) {
            System.out.println("Error: Please fill out all fields before assigning the task.");
            return;
        }


        System.out.println("Success: Task '" + taskId + " - " + title + "' assigned to " + department + " Department.");
        System.out.println("Deadline set for: " + deadline.toString());


        handleClearForm(event);
    }


    @FXML
    void handleClearForm(ActionEvent event) {
        taskIdField.clear();
        taskTitleField.clear();
        departmentComboBox.getSelectionModel().clearSelection();
        deadlinePicker.setValue(null);
        taskDescriptionArea.clear();

        System.out.println("System: Form fields have been cleared.");
    }


    @FXML
    void handleBackButton(ActionEvent event) {
        try {
            // Load the destination FXML (Update "Governor.fxml" if your dashboard name is different)
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Governor.fxml"));
            Parent root = loader.load();

            // Get the current stage from the button event
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Set the new scene
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