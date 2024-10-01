package com.example.TranslateService;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TranslateService {
    private static final Map<String, String> translations = new HashMap<>();

    static {
        translations.put("ingles", "Hello");
        translations.put("frances", "Bonjour");
        translations.put("italiano", "Ciao");
    }

    public String translate(String message, String source, String target) {
        if ("Hola".equalsIgnoreCase(message)) {
            String translation = translations.get(target.toLowerCase());
            if (translation != null) {
                return translation;
            } else {
                return "Translation not available";
            }
        }
        return "Only 'Hola' can be translated for now";
    }
}