package com.example.demo.service;

import com.example.demo.data.Friend;
import com.example.demo.data.FriendListResponse;
import com.example.demo.data.Game;
import com.example.demo.data.GameListResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class GeminiService {
    private final RestTemplate restTemplate;

    @Value("${google.gemini.api.key}")
    private String geminiApiKey;

    public GeminiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String callGeminiAI(String prompt) {
        String url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=" + geminiApiKey;
        String requestBody = "{\n" +
                "  \"contents\": [{\n" +
                "    \"parts\":[{\"text\": \"" + prompt + "\"}]\n" +
                "    }]\n" +
                "}";
        ResponseEntity<String> response = restTemplate.postForEntity(url, requestBody, String.class);
        ObjectMapper mapper = new ObjectMapper();
        return response.getBody();
    }

}
