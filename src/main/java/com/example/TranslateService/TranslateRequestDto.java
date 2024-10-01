package com.example.TranslateService;

public record TranslateRequestDto(
        String message,
        String source,
        String target
) {
}