package com.example.TranslateService;

import kong.unirest.Unirest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class TranslateServiceTest {

    @Test
    void translate() {
        TranslateService service = new TranslateService();
        String text = "Hola";

        assertEquals("Hello", service.translate("Hola", "espanol","ingles"));
    }

}