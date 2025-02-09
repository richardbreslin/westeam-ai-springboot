package com.richardbreslin.westeam.controller;

import com.richardbreslin.westeam.data.*;
import com.richardbreslin.westeam.service.GeminiService;
import com.richardbreslin.westeam.service.SteamService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@RestController
public class MainController {

    private final SteamService steamService;
    private final GeminiService geminiService;

    public MainController(SteamService steamService, GeminiService geminiService) {
        this.steamService = steamService;
        this.geminiService = geminiService;
    }

    //Home Page
    @GetMapping("/")
    public Resource home() {
        return new ClassPathResource("static/index.html");
    }

    @GetMapping("/api/getFriends")
    public List<Friend> getFriends(@RequestParam String steamId) throws JsonProcessingException {
        return steamService.getFriends(steamId);
    }

    @GetMapping("api/getOwnedGames")
    public List<Game> getOwnedGames(@RequestParam List<String> steamId) throws JsonProcessingException {
        return steamService.getCommonlyOwnedGames(steamId);
    }

    // Example Data: "76561198040415511", "76561198028109433"
    @GetMapping("api/getRecommendations")
    public ResponseEntity<GeminiRecommendationsResponse> getReccomentations(@RequestParam List<String> steamId) throws JsonProcessingException {
        List<Game> gamesList = getOwnedGames(steamId);
        String GameListCSV = gamesList.stream().map(game -> String.valueOf(game.getAppid())).collect(Collectors.joining(","));
        List<GameDetails> GameDetailsList = getGameDetails(Arrays.asList(GameListCSV.split(",")));
        String prompt = new Prompt().buildPrompt(GameDetailsList);
        return geminiService.callGeminiAI(prompt);
    }

    @GetMapping("api/getGameDetails")
    public List<GameDetails> getGameDetails(@RequestParam List<String> appid) throws JsonProcessingException {
    return steamService.getGameDetails(appid);
    }
}
