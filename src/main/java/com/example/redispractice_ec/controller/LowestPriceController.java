package com.example.redispractice_ec.controller;

import com.example.redispractice_ec.service.LowestPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("")
public class LowestPriceController {

    @Autowired
    private LowestPriceService lowestPriceService;

    //http://localhost:8080/getZSETValue?key=highScores
    @GetMapping("/getZSETValue")
    public Set<?> getZSETValue(String key){
        return lowestPriceService.getZSETValue(key);
    }
}
