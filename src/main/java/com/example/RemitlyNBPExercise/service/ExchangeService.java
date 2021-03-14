package com.example.RemitlyNBPExercise.service;

import com.example.RemitlyNBPExercise.dto.NBPDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@Slf4j
public class ExchangeService {

    //Spring Boot tool which help to establish connection

    private RestTemplate restTemplate = new RestTemplate();

    //Method responsible for getting value from JSON data
    //using getExchangeForCurrency() you get value of GBP from table rates in JSON

    public double getExchange() {
        NBPDto nbpDto = getExchangeForCurrency("gbp");
        double gbpValue = nbpDto.rates[0].mid;
        return gbpValue;
    }

    //Method which is connecting with API
    //In method paramether you pass currency (as String) you need, like above GBP

    private NBPDto getExchangeForCurrency(String currency) {
        return restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/rates/a/{currency}/?format=json",
                NBPDto.class,
                currency);
    }
}
