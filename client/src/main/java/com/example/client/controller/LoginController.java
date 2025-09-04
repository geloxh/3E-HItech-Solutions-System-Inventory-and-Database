package com.example.client.controller;

import com.example.client.service.SessionManager;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginController {
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;
    @FXML
    private Button registerButton;
    @FXML
    private Label messageLabel;

    private final SessionManager sessionManager = SessionManager.getInstance();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            messageLabel.setText("Please fill in all fields");
            return;
        }

        try {
            Map<String, String> loginRequest = new HashMap<>();
            loginRequest.put("username", username);
            loginRequest.put("password", password);

            String response = sessionManager.getApiClient().post("/auth/login", loginRequest);
            JsonNode jsonNode = objectMapper.readTree(response);

            if (jsonNode.has("token")) {
                String token = jsonNode.get("token").asText();
                sessionManager.setSession(username, token);
                openMainWindow();
            } else {
                messageLabel.setText("Login failed");
            }
        } catch (Exception e) {
            messageLabel.setText("Error: " + e.getMessage());
        }
    }

    @FXML
    private void handleRegister() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            messageLabel.setText("Please fill in all fields");
            return;
        }

        try {
            Map<String, String> registerRequest = new HashMap<>();
            registerRequest.put("username", username);
            registerRequest.put("email", username + "@example.com"); // Simple email generation
            registerRequest.put("password", password);

            String response = sessionManager.getApiClient().post("/auth/register", registerRequest);
            
            if (response.contains("successfully")) {
                messageLabel.setText("Registration successful! Please login.");
            } else {
                messageLabel.setText("Registration failed");
            }
        } catch (Exception e) {
            messageLabel.setText("Error: " + e.getMessage());
        }
    }

    private void openMainWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) loginButton.getScene().getWindow();
        stage.setTitle("Asset Manager - Main");
        stage.setScene(new Scene(root, 800, 600));
        stage.centerOnScreen();
        stage.setResizable(true);
    }
}
