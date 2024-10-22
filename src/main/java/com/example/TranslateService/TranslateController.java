package com.example.TranslateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public class TranslateController implements TranslateApi {

    @Autowired
    private TranslateService translateService;

    @GetMapping
    public String translate(@RequestBody TranslateRequestDto requestDto) {
        return this.translateService.translate(
                requestDto.message(),
                requestDto.source(),
                requestDto.target()
        );
    }
}
