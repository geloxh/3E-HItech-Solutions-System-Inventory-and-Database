package com.example.client.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;

import java.io.IOException;

public class ApiClient {
    private final String baseUrl = "http://localhost:8080/api";
    private final CloseableHttpClient httpClient;
    private final ObjectMapper objectMapper;
    private String authToken;

    public ApiClient() {
        this.httpClient = HttpClients.createDefault();
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new JavaTimeModule());
    }

    public void setAuthToken(String token) {
        this.authToken = token;
    }

    public String post(String endpoint, Object requestBody) throws IOException {
        HttpPost post = new HttpPost(baseUrl + endpoint);
        
        if (authToken != null) {
            post.setHeader("Authorization", "Bearer " + authToken);
        }
        
        String json = objectMapper.writeValueAsString(requestBody);
        post.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        
        return httpClient.execute(post, response -> {
            return EntityUtils.toString(response.getEntity());
        });
    }

    public String get(String endpoint) throws IOException {
        HttpGet get = new HttpGet(baseUrl + endpoint);
        
        if (authToken != null) {
            get.setHeader("Authorization", "Bearer " + authToken);
        }
        
        return httpClient.execute(get, response -> {
            return EntityUtils.toString(response.getEntity());
        });
    }

    public void close() throws IOException {
        httpClient.close();
    }
}
