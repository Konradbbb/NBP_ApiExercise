package com.example.RemitlyNBPExercise.model;

import com.example.RemitlyNBPExercise.service.ExchangeService;
import lombok.Getter;
import org.springframework.context.annotation.Bean;

@Getter
public class ExchangeClient {

    //class responsible for passing values to Thymeleaf
    // unfortunetly it is not working perfectly so I decided to set a default value to both valueToCalculate and valueToReturn

    ExchangeService exchangeService = new ExchangeService();

    public double valueToCalculate = 5;
    public double valueToRaturn = 1;

    public ExchangeClient(double valueToCalculate, double valueToRaturn) {
        this.valueToCalculate = valueToCalculate;
        this.valueToRaturn = valueToRaturn;
    }

    public ExchangeClient(){}

    //method used to caltulate valueToReturn, depends on current GBP rate and value passed by user (by default it is 5)

    public double calculateValue() {
        valueToRaturn = exchangeService.getExchange() * this.valueToCalculate;
        return Math.round(valueToRaturn); // Math.round used to round the double value
    }

    @Override
    public String toString() {
        return "ExchangeClient{" +
                ", valueToCalculate=" + valueToCalculate +
                ", valueToRaturn=" + valueToRaturn +
                '}';
    }
}
