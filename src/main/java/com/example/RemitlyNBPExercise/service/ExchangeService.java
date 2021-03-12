package com.example.RemitlyNBPExercise.service;

import com.example.RemitlyNBPExercise.dto.NBPDto;
import lombok.extern.slf4j.Slf4j;
import com.example.RemitlyNBPExercise.model.ExchangeDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
@Slf4j
public class ExchangeService {

    private RestTemplate restTemplate = new RestTemplate();

    public ExchangeDto getExchange() {

        NBPDto nbpDto = getExchangeForCurrency("gbp");

        return ExchangeDto.builder()
                .mid(nbpDto.rates[0].mid)
                .build();

    }

    public double caculate() {
        double value = getExchange().getMid();
        return value;
    }

    private NBPDto getExchangeForCurrency(String currency) {
        return restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/rates/a/{currency}/?format=json", NBPDto.class, currency);
    }
}
