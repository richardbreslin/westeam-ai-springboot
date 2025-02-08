package com.example.demo.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Time;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Game implements Serializable {
    private Integer appid;
    private Integer playtime_forever;
    private Integer playtime_windows_forever;
    private Integer playtime_mac_forever;
    private Integer playtime_linux_forever;
    private Integer playtime_deck_forever;
    private Integer rtime_last_played;
    private Integer playtime_disconnected;
    private Integer playtime_2weeks;
}
