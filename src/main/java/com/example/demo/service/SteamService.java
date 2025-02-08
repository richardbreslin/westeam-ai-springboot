package com.example.demo.service;

import com.example.demo.data.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class SteamService {

    private final RestTemplate restTemplate;

    @Value("${steam.api.key}")
    private String steamApiKey;

    public SteamService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Friend> getFriends(String steamId) throws JsonProcessingException {
        String url = "http://api.steampowered.com/ISteamUser/GetFriendList/v0001/?key=" + steamApiKey + "&steamid=" + steamId + "&relationship=friend";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        FriendListResponse friendListResponse = mapper.readValue(response.getBody(), FriendListResponse.class);
        List<Friend> friends = friendListResponse.getFriendsList().getFriends();
        System.out.println(friends);

        return friends;
    }

    public List<Game> getOwnedGames(String steamId) throws JsonProcessingException {
        String url = "http://api.steampowered.com/IPlayerService/GetOwnedGames/v0001/?key=" + steamApiKey + "&steamid=" + steamId + "&format=friend";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        GameListResponse gameListResponse = mapper.readValue(response.getBody(), GameListResponse.class);
        List<Game> games = gameListResponse.getResponse().getGameList();
        System.out.println(games);

        return games;
    }

    public List<Game> getCommonlyOwnedGames(List<String> steamId) throws JsonProcessingException {
        List<Game> allOwnedGames = new ArrayList<>();
        for (String id : steamId) {
            System.out.println(id);
            if (allOwnedGames.isEmpty()) {
                allOwnedGames.addAll(getOwnedGames(id));
            } else {
                List<Game> ownedGames = getOwnedGames(id);
                ownedGames.stream()
                    .filter(game -> allOwnedGames.stream().anyMatch(game1 -> game1.getAppid().equals(game.getAppid())))
                    .forEach(game -> {
                        if (allOwnedGames.stream().noneMatch(g -> g.getAppid().equals(game.getAppid()))) {
                            allOwnedGames.add(game);
            }
                    });
            }
        }
        return allOwnedGames;
    }

    public List<String> getGameDetails(List<String> appId) throws JsonProcessingException {
        List<String> gameDetails = new ArrayList<>();

        for (String appid : appId) {
            String url = "https://store.steampowered.com/api/appdetails?appids=" + appid;
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            gameDetails.add(response.getBody());
        }
        return gameDetails;
    }
}
