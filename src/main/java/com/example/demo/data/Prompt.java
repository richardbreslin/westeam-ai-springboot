package com.example.demo.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class Prompt {
    private final String PROMPT = """
            
            Using the provided list of games, recommend 5 games that would be great for us to play together. The list includes games that all party members own, along with detailed Steam game data (title, description, pricing, etc.). Prioritize recommendations based on cooperative or multiplayer gameplay, replayability, and overall enjoyment for a group.
                        
            Return the response in the following JSON format:
                        
            {
              "recommendations": [
                {
                  "title": "Game Title",
                  "reason": "Brief explanation of why this game is recommended"
                },
              ]
            }
            
            """;

    public String buildPrompt(List<GameDetails> gameDetailsList) {
        ObjectMapper objectMapper = new ObjectMapper();
        return PROMPT + gameDetailsList.stream()
                .map(gameDetails -> {
                    try {
                        return objectMapper.writeValueAsString(gameDetails);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                        return "Internal Server Error";
                    }
                })
                .collect(Collectors.joining(", "));
    }
}
