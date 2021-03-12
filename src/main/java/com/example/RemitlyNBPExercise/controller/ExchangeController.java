package com.example.RemitlyNBPExercise.controller;


//import com.example.RemitlyNBPExercise.model.ExchangeClient;
import lombok.RequiredArgsConstructor;
import com.example.RemitlyNBPExercise.model.ExchangeDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.RemitlyNBPExercise.service.ExchangeService;

@Controller
@RequiredArgsConstructor
public class ExchangeController {

    private final ExchangeService exchangeService;

    @GetMapping("/GBP")
    public String getExchangeGBP(Model model) {
//        double inputValue = exchangeService.getInput();
        double gbpValue = exchangeService.getExchange();
        model.addAttribute("gbpValue", gbpValue);
//        model.addAttribute("newClient", new ExchangeClient());
        return "index";
    }

//    @PostMapping("/calculateValue")
//    public String calculateVaule(@ModelAttribute ExchangeClient exchangeClient, Model model){
//        double valueToReturn;
//        valueToReturn = exchangeClient.getValueToCalculate() * exchangeService.getExchange();
//        model.addAttribute("valueToReturn", valueToReturn);
//        return "index";
//    }
}
