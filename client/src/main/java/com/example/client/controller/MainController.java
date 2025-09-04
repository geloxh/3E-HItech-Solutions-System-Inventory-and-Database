package com.example.client.controller;

import com.example.client.service.SessionManager;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainController {
    @FXML
    private Label welcomeLabel;
    @FXML
    private TabPane mainTabPane;
    @FXML
    private TableView assetsTable;
    @FXML
    private TableView usageLogsTable;
    @FXML
    private TableView conditionLogsTable;
    @FXML
    private TableView eventLogsTable;
    @FXML
    private TableView locationLogsTable;

    private final SessionManager sessionManager = SessionManager.getInstance();

    @FXML
    private void initialize() {
        welcomeLabel.setText("Welcome, " + sessionManager.getUsername());
        
        // Initialize tables - simplified for demo
        setupAssetsTable();
        setupLogsTable();
    }

    private void setupAssetsTable() {
        // Add columns for assets table
        TableColumn<Object, String> assetTagColumn = new TableColumn<>("Asset Tag");
        assetTagColumn.setCellValueFactory(new PropertyValueFactory<>("assetTag"));
        
        TableColumn<Object, String> typeColumn = new TableColumn<>("Type");
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("assetType"));
        
        TableColumn<Object, String> brandColumn = new TableColumn<>("Brand");
        brandColumn.setCellValueFactory(new PropertyValueFactory<>("brand"));
        
        assetsTable.getColumns().addAll(assetTagColumn, typeColumn, brandColumn);
    }

    private void setupLogsTable() {
        // Setup usage logs table
        TableColumn<Object, String> actionColumn = new TableColumn<>("Action");
        actionColumn.setCellValueFactory(new PropertyValueFactory<>("action"));
        
        TableColumn<Object, String> dateColumn = new TableColumn<>("Date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("loggedAt"));
        
        usageLogsTable.getColumns().addAll(actionColumn, dateColumn);
        
        // Similar setup for other log tables
        conditionLogsTable.getColumns().addAll(
            new TableColumn<>("Condition"),
            new TableColumn<>("Date")
        );
        
        eventLogsTable.getColumns().addAll(
            new TableColumn<>("Event"),
            new TableColumn<>("Date")
        );
        
        locationLogsTable.getColumns().addAll(
            new TableColumn<>("Location"),
            new TableColumn<>("Date")
        );
    }

    @FXML
    private void handleAddAsset() {
        showAlert("Feature Coming Soon", "Add Asset functionality will be implemented here.");
    }

    @FXML
    private void handleAddUsageLog() {
        showAlert("Feature Coming Soon", "Add Usage Log functionality will be implemented here.");
    }

    @FXML
    private void handleAddConditionLog() {
        showAlert("Feature Coming Soon", "Add Condition Log functionality will be implemented here.");
    }

    @FXML
    private void handleAddEventLog() {
        showAlert("Feature Coming Soon", "Add Event Log functionality will be implemented here.");
    }

    @FXML
    private void handleAddLocationLog() {
        showAlert("Feature Coming Soon", "Add Location Log functionality will be implemented here.");
    }

    @FXML
    private void handleLogout() {
        sessionManager.clearSession();
        // Close current window and return to login - simplified for demo
        showAlert("Logged Out", "You have been logged out successfully.");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
