package com.example.demo.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameListResponse {


    @JsonProperty("response")
    private GameList response;

    @Getter
    @Setter
    public static class GameList {
        @JsonProperty("games")
        private List<Game> gameList;

        @JsonProperty("game_count")
        private Integer game_count;

    }
}