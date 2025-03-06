package com.richardbreslin.westeam.data;

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
public class SteamAppList {

    @JsonProperty("applist")
    private AppList appList;

    @Getter
    @Setter
    public static class AppList {
        @JsonProperty("apps")
        private List<App> apps;
    }

    @Getter
    @Setter
    public static class App {
        @JsonProperty("appid")
        private int appid;

        @JsonProperty("name")
        private String name;
    }

}
