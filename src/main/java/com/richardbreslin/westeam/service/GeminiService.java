package com.richardbreslin.westeam.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.richardbreslin.westeam.data.GeminiRecommendationsResponse;
import com.richardbreslin.westeam.data.GeminiRequest;
import com.richardbreslin.westeam.data.GeminiResponse;
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

    public ResponseEntity<GeminiRecommendationsResponse> callGeminiAI(String prompt) {
        String url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=" + geminiApiKey;
        String response = restTemplate.postForEntity(url, buildRequestBody(prompt), String.class).getBody();
        return ResponseEntity.ok(buildRecommendations(response));
    }

    private String buildRequestBody(String prompt) {
        GeminiRequest gemeniRequest = GeminiRequest.builder()
                .contents(List.of(
                        GeminiRequest.Content.builder()
                                .parts(List.of(
                                        GeminiRequest.Part.builder()
                                                .text(prompt)
                                                .build()
                                ))
                                .build()
                ))
                .build();
        String requestBody;
        try {
            ObjectMapper mapper = new ObjectMapper();
            requestBody = mapper.writeValueAsString(gemeniRequest);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error processing JSON", e);
        }
        return requestBody;
    }

    private GeminiRecommendationsResponse buildRecommendations(String response) {
        ObjectMapper mapper = new ObjectMapper();
        GeminiResponse gemeniResponse;
        try {
            gemeniResponse = mapper.readValue(response, GeminiResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error processing JSON response", e);
        }

        String GemeniRecommendationsJSON = gemeniResponse.getCandidates().getFirst().getContent().getParts().getFirst().getText();
        String GemeniRecommendationsJSONCleaned = GemeniRecommendationsJSON.replaceFirst("^```json\\n", "").replaceFirst("\\n```$", "");
        GeminiRecommendationsResponse recommendations = new GeminiRecommendationsResponse();

        try {
            recommendations = mapper.readValue(GemeniRecommendationsJSONCleaned, GeminiRecommendationsResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error processing JSON response", e);
        }
        return recommendations;
    }

}
