package com.example.RemitlyNBPExercise.controller;


import com.example.RemitlyNBPExercise.model.ExchangeClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.RemitlyNBPExercise.service.ExchangeService;

@Controller
@RequiredArgsConstructor
public class ExchangeController {

    //class resposible for creating endpoints and start actions depends on using methods (@Get or @Post)
    // unfortunetly it is not working perfect :(

    private final ExchangeService exchangeService = new ExchangeService();

    @GetMapping("/GBP")
    public String getExchangeGBP(Model model) {
        double gbpValue = exchangeService.getExchange();
        model.addAttribute("gbpValue", gbpValue);
        model.addAttribute("newClient", new ExchangeClient());
        return "GBP";
    }

    @PostMapping("/GBP")
    public String calculateValue(@ModelAttribute ExchangeClient exchangeClient, Model model){
        System.out.println(exchangeClient);
        model.addAttribute("valueToCalculate", exchangeClient.valueToCalculate);
        return "GBP";
    }
}
