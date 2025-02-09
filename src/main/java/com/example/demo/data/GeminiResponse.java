package com.example.demo.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
public class GeminiResponse {

    @JsonProperty("candidates")
    public ArrayList<Candidate> getCandidates() {
        return this.candidates;
    }

    public void setCandidates(ArrayList<Candidate> candidates) {
        this.candidates = candidates;
    }

    ArrayList<Candidate> candidates;

    @JsonProperty("usageMetadata")
    public UsageMetadata getUsageMetadata() {
        return this.usageMetadata;
    }

    public void setUsageMetadata(UsageMetadata usageMetadata) {
        this.usageMetadata = usageMetadata;
    }

    UsageMetadata usageMetadata;

    @JsonProperty("modelVersion")
    public String getModelVersion() {
        return this.modelVersion;
    }

    public void setModelVersion(String modelVersion) {
        this.modelVersion = modelVersion;
    }

    String modelVersion;


    public static class Candidate {
        @JsonProperty("content")
        public Content getContent() {
            return this.content;
        }

        public void setContent(Content content) {
            this.content = content;
        }

        Content content;

        @JsonProperty("finishReason")
        public String getFinishReason() {
            return this.finishReason;
        }

        public void setFinishReason(String finishReason) {
            this.finishReason = finishReason;
        }

        String finishReason;

        @JsonProperty("avgLogprobs")
        public double getAvgLogprobs() {
            return this.avgLogprobs;
        }

        public void setAvgLogprobs(double avgLogprobs) {
            this.avgLogprobs = avgLogprobs;
        }

        double avgLogprobs;
    }

    public static class CandidatesTokensDetail {
        @JsonProperty("modality")
        public String getModality() {
            return this.modality;
        }

        public void setModality(String modality) {
            this.modality = modality;
        }

        String modality;

        @JsonProperty("tokenCount")
        public int getTokenCount() {
            return this.tokenCount;
        }

        public void setTokenCount(int tokenCount) {
            this.tokenCount = tokenCount;
        }

        int tokenCount;
    }

    public static class Content {
        @JsonProperty("parts")
        public ArrayList<Part> getParts() {
            return this.parts;
        }

        public void setParts(ArrayList<Part> parts) {
            this.parts = parts;
        }

        ArrayList<Part> parts;

        @JsonProperty("role")
        public String getRole() {
            return this.role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        String role;
    }

    public static class Part {
        @JsonProperty("text")
        public String getText() {
            return this.text;
        }

        public void setText(String text) {
            this.text = text;
        }

        String text;
    }

    public static class PromptTokensDetail {
        @JsonProperty("modality")
        public String getModality() {
            return this.modality;
        }

        public void setModality(String modality) {
            this.modality = modality;
        }

        String modality;

        @JsonProperty("tokenCount")
        public int getTokenCount() {
            return this.tokenCount;
        }

        public void setTokenCount(int tokenCount) {
            this.tokenCount = tokenCount;
        }

        int tokenCount;
    }

    public static class UsageMetadata {
        @JsonProperty("promptTokenCount")
        public int getPromptTokenCount() {
            return this.promptTokenCount;
        }

        public void setPromptTokenCount(int promptTokenCount) {
            this.promptTokenCount = promptTokenCount;
        }

        int promptTokenCount;

        @JsonProperty("candidatesTokenCount")
        public int getCandidatesTokenCount() {
            return this.candidatesTokenCount;
        }

        public void setCandidatesTokenCount(int candidatesTokenCount) {
            this.candidatesTokenCount = candidatesTokenCount;
        }

        int candidatesTokenCount;

        @JsonProperty("totalTokenCount")
        public int getTotalTokenCount() {
            return this.totalTokenCount;
        }

        public void setTotalTokenCount(int totalTokenCount) {
            this.totalTokenCount = totalTokenCount;
        }

        int totalTokenCount;

        @JsonProperty("promptTokensDetails")
        public ArrayList<PromptTokensDetail> getPromptTokensDetails() {
            return this.promptTokensDetails;
        }

        public void setPromptTokensDetails(ArrayList<PromptTokensDetail> promptTokensDetails) {
            this.promptTokensDetails = promptTokensDetails;
        }

        ArrayList<PromptTokensDetail> promptTokensDetails;

        @JsonProperty("candidatesTokensDetails")
        public ArrayList<CandidatesTokensDetail> getCandidatesTokensDetails() {
            return this.candidatesTokensDetails;
        }

        public void setCandidatesTokensDetails(ArrayList<CandidatesTokensDetail> candidatesTokensDetails) {
            this.candidatesTokensDetails = candidatesTokensDetails;
        }

        ArrayList<CandidatesTokensDetail> candidatesTokensDetails;
    }


}

