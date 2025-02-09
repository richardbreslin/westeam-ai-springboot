package com.example.demo.data;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class GemeniRequest {
    private List<Content> contents;

    @Setter
    @Getter
    @Builder
    public static class Content {
        private List<Part> parts;

    }

    @Setter
    @Getter
    @Builder
    public static class Part {
        private String text;

    }
}