package com.richardbreslin.westeam.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class GeminiRecommendationsResponse {
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
