package com.example.demo.data;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class GemeniRecommendations {
    @JsonProperty("recommendations")
    public ArrayList<Recommendation> getRecommendations() {
        return this.recommendations;
    }

    public void setRecommendations(ArrayList<Recommendation> recommendations) {
        this.recommendations = recommendations;
    }

    ArrayList<Recommendation> recommendations;

    public static class Recommendation {
        @JsonProperty("title")
        public String getTitle() {
            return this.title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        String title;

        @JsonProperty("reason")
        public String getReason() {
            return this.reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        String reason;
    }

}
