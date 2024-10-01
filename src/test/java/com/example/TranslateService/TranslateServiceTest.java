package com.example.TranslateService;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TranslateServiceTest {

    @Test
    void translate() {
        TranslateService service = new TranslateService();
        String text = "Hola";

        assertEquals("Hello", service.translate("Hola", "espanol","ingles"));
    }
}