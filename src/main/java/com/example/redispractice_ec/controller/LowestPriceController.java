package com.example.redispractice_ec.controller;

import com.example.redispractice_ec.dto.Product;
import com.example.redispractice_ec.service.LowestPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    
    @PutMapping("/product")
    public int setNewProduct(@RequestBody Product newProduct){
        return lowestPriceService.setNewProduct(newProduct);
    }

}
