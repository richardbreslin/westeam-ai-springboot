package com.richardbreslin.westeam.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.richardbreslin.westeam.data.*;
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

    public ResponseEntity<String> getFriends(String steamId) throws JsonProcessingException {
        FriendListResponse friendListResponse = ISteamUserGetFriendList(steamId);
        String url = buildFriendsListDetailsURL(friendListResponse.getFriendsList().getFriends());
        return restTemplate.getForEntity(url, String.class);
    }



    public List<Game> getOwnedGames(String steamId) throws JsonProcessingException {
        String url = "http://api.steampowered.com/IPlayerService/GetOwnedGames/v0001/?key=" + steamApiKey + "&steamid=" + steamId + "&format=friend";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        GameListResponse gameListResponse = mapper.readValue(response.getBody(), GameListResponse.class);
        List<Game> games = gameListResponse.getResponse().getGameList();
        return games;
    }

    public List<Game> getCommonlyOwnedGames(List<String> steamId) throws JsonProcessingException {
        List<Game> allOwnedGames = new ArrayList<>();
        for (String id : steamId) {
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

    public List<GameDetails> getGameDetails(List<String> appId) throws JsonProcessingException {
        List<GameDetails> gameDetails = new ArrayList<>();

        for (String appid : appId) {
            String url = "https://store.steampowered.com/api/appdetails?appids=" + appid + "&l=english";
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            ObjectMapper mapper = new ObjectMapper();
            GameDetails gameDetail = mapper.readValue(response.getBody(), GameDetails.class);
            gameDetails.add(gameDetail);
        }
        return gameDetails;
    }

    private FriendListResponse ISteamUserGetFriendList(String steamId) throws JsonProcessingException {
        String ISteamUserGetFriendListURL = "http://api.steampowered.com/ISteamUser/GetFriendList/v0001/?key=" + steamApiKey + "&steamid=" + steamId + "&relationship=friend";
        ResponseEntity<String> response = restTemplate.getForEntity(ISteamUserGetFriendListURL, String.class);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.getBody(), FriendListResponse.class);
    }

    private String buildFriendsListDetailsURL(List<Friend> friends) {
        StringBuilder url = new StringBuilder("http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/?key=" + steamApiKey + "&steamids=");
        for (Friend friend : friends) {
            url.append(friend.getSteamid()).append(",");
        }
        return url.toString();
    }
}
