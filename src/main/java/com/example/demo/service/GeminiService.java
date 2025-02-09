package com.example.demo.service;

import com.example.demo.data.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class GeminiService {
    private final RestTemplate restTemplate;

    @Value("${google.gemini.api.key}")
    private String geminiApiKey;

    public GeminiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<GemeniRecommendations> callGeminiAI(String prompt) {
        String url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=" + geminiApiKey;
        String requestBody = "";

        GemeniRequest gemeniRequest = GemeniRequest.builder()
                .contents(List.of(
                        GemeniRequest.Content.builder()
                                .parts(List.of(
                                        GemeniRequest.Part.builder()
                                                .text(prompt)
                                                .build()
                                ))
                                .build()
                ))
                .build();

        try {
            ObjectMapper mapper = new ObjectMapper();
            requestBody = mapper.writeValueAsString(gemeniRequest);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error processing JSON", e);
        }


        String response = restTemplate.postForEntity(url, requestBody, String.class).getBody();
        ObjectMapper mapper = new ObjectMapper();
        GemeniResponse gemeniResponse;
        try {
            gemeniResponse = mapper.readValue(response, GemeniResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error processing JSON response", e);
        }

        String GemeniRecommendationsJSON = gemeniResponse.getCandidates().getFirst().getContent().getParts().getFirst().getText();
        String GemeniRecommendationsJSONCleaned = GemeniRecommendationsJSON.replaceFirst("^```json\\n", "").replaceFirst("\\n```$", "");
        GemeniRecommendations recommendations = new GemeniRecommendations();

        try {
             recommendations = mapper.readValue(GemeniRecommendationsJSONCleaned, GemeniRecommendations.class);

        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error processing JSON response", e);
        }

        return ResponseEntity.ok(recommendations);
    }

}
