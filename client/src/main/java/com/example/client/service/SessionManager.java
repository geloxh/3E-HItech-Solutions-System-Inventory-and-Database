package com.example.client.service;

public class SessionManager {
    private static SessionManager instance;
    private String username;
    private String token;
    private ApiClient apiClient;

    private SessionManager() {
        this.apiClient = new ApiClient();
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void setSession(String username, String token) {
        this.username = username;
        this.token = token;
        this.apiClient.setAuthToken(token);
    }

    public void clearSession() {
        this.username = null;
        this.token = null;
        this.apiClient.setAuthToken(null);
    }

    public boolean isLoggedIn() {
        return token != null && !token.isEmpty();
    }

    public String getUsername() {
        return username;
    }

    public String getToken() {
        return token;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }
}
