package com.richardbreslin.westeam.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.richardbreslin.westeam.data.*;
import com.richardbreslin.westeam.entity.SteamAppEntity;
import com.richardbreslin.westeam.repository.WesteamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class SteamService {

    private final RestTemplate restTemplate;
    private final WesteamRepository westeamRepository;



    @Value("${steam.api.key}")
    private String steamApiKey;

    public SteamService(RestTemplate restTemplate, WesteamRepository westeamRepository) {
        this.restTemplate = restTemplate;
        this.westeamRepository = westeamRepository;
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

    public List<String> getGameDetails(List<String> appId) throws JsonProcessingException {
        List<String> gameDetails = new ArrayList<>();

        for (String appid : appId) {

            String response = getSteamAppIdDetails(appid);

            if (response == null || response.isEmpty()) {
                System.out.println(appid + " not found in local database, fetching from Steam API");
                String details = getSteamAppDetails(appid);
                if (details != null && !details.isEmpty()) {
                    insertSteamAppDetails(appid, details);
                }
            }

//            ObjectMapper mapper = new ObjectMapper();
//            GameDetails gameDetail = mapper.readValue(response, GameDetails.class);
            gameDetails.add(response);
        }
        return gameDetails;
    }

    private String getSteamAppIdDetails(String appid) {
        SteamAppEntity entity = westeamRepository.findById(appid).orElse(null);
        return entity != null ? entity.getDetails() : null;
    }

    private void insertSteamAppDetails(String appid, String details) {
        SteamAppEntity entity = SteamAppEntity.builder()
                .details(details)
                .updatedAt(LocalDateTime.now())
                .createdAt(LocalDateTime.now())
                .appid(appid)
                .build();
        westeamRepository.save(entity);
        System.out.println("Saved app details for: " + appid);
    }



    public SteamAppList getSteamAppList() throws JsonProcessingException {
        String url = "http://api.steampowered.com/ISteamApps/GetAppList/v2";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.getBody(), SteamAppList.class);
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

    public String getSteamAppDetails(String appid) {
        try {
            String url = "https://store.steampowered.com/api/appdetails?appids=" + appid + "&l=english";
            return restTemplate.getForObject(url, String.class);
        } catch (Exception e) {
            System.err.println("Error fetching details for appid " + appid + ": " + e.getMessage());
            return null;
        }
    }

}
