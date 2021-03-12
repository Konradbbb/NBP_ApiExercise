package com.example.RemitlyNBPExercise.controller;


import lombok.RequiredArgsConstructor;
import com.example.RemitlyNBPExercise.model.ExchangeDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.RemitlyNBPExercise.service.ExchangeService;

@RestController
@RequiredArgsConstructor
public class ExchangeController {

    private final ExchangeService exchangeService;

    @GetMapping("/GBP")
    public ExchangeDto getExchangeGBP() {
        return exchangeService.getExchange();
    }
}
