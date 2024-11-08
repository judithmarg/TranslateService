package com.example.TranslateService;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${rapidapi.key}")
    private String apiKey;

    @Value("${rapidapi.host}")
    private String apiHost;

    private static final String TRANSLATE_URL = "https://google-translate1.p.rapidapi.com/language/translate/v2";

    public String translateText(String text, String targetLanguage, String sourceLanguage) {
        try {
            HttpResponse<JsonNode> response = Unirest.post(TRANSLATE_URL)
                    .header("x-rapidapi-key", apiKey)
                    .header("x-rapidapi-host", apiHost)
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .field("q", text)
                    .field("target", targetLanguage)
                    .field("source", sourceLanguage)
                    .asJson();

            if (response.getStatus() == 200) {
                return response.getBody()
                        .getObject()
                        .getJSONObject("data")
                        .getJSONArray("translations")
                        .getJSONObject(0)
                        .getString("translatedText");
            } else {
                return "Error: " + response.getStatusText();
            }
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

}