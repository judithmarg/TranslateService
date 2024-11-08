package com.example.TranslateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/translations")
@RestController
public class TranslateController implements TranslateApi {

    private final TranslateService translateService;

    @Autowired
    public TranslateController(TranslateService translateService) {
        this.translateService = translateService;
    }

    @GetMapping("/translate1")
    public String translate(@RequestBody TranslateRequestDto requestDto) {
        return this.translateService.translate(
                requestDto.message(),
                requestDto.source(),
                requestDto.target()
        );
    }

    @GetMapping("/translate2")
    public ResponseEntity<TranslateResponseDto> translateText(@RequestParam TranslateRequestDto requestDto) {
        String response =  this.translateService.translate(
                requestDto.message(),
                requestDto.target(),
                requestDto.source()
        );
        TranslateResponseDto responseDto = new TranslateResponseDto(response);
        return ResponseEntity.ok(responseDto);
    }
}
