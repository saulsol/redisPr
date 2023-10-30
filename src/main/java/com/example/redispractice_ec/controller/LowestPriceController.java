package com.example.redispractice_ec.controller;

import com.example.redispractice_ec.dto.Keyword;
import com.example.redispractice_ec.dto.Product;
import com.example.redispractice_ec.dto.ProductGroup;
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

    @PutMapping("/productGroup")
    public int setNewProduct(@RequestBody ProductGroup productGroup){
        return lowestPriceService.setNewProductGroup(productGroup);
    }

    @PutMapping("/productGroupToKeyword")
    public int setNewProduct(String keyword, String prdId, double score){
        return lowestPriceService.setNewProductGroupKeyword(keyword, prdId, score);
    }

//    @GetMapping("/productPrice/lowest")
//    public Keyword getLowestPriceProductByKeyword(String keyword){
//
//    }

}
