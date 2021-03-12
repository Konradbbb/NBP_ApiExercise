package com.example.RemitlyNBPExercise.service;

import com.example.RemitlyNBPExercise.dto.NBPDto;
import lombok.extern.slf4j.Slf4j;
import com.example.RemitlyNBPExercise.model.ExchangeDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.MissingResourceException;
import java.util.Scanner;

@Service
@Slf4j
public class ExchangeService {

    private RestTemplate restTemplate = new RestTemplate();

    public double getExchange() {
        NBPDto nbpDto = getExchangeForCurrency("gbp");
        double gbpValue = nbpDto.rates[0].mid;
        return gbpValue;
    }

    private NBPDto getExchangeForCurrency(String currency) {
        return restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/rates/a/{currency}/?format=json",
                NBPDto.class,
                currency);
    }
}
