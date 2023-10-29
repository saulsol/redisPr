package com.example.redispractice_ec.service;

import com.example.redispractice_ec.dto.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class LowestPriceService {

    private final RedisTemplate<String, Object> redisTemplate;

    public Set<?> getZSETValue(String key){
        Set<?> myTempSet = new HashSet<>();
        myTempSet = redisTemplate.opsForZSet().rangeWithScores(key, 0, 9);
        return myTempSet;
    }

    public int setNewProduct(Product newProduct){
        int rank = 0;
        redisTemplate.opsForZSet().add(
                newProduct.getProductGroupId(),
                newProduct.getProductId(),
                newProduct.getPrice()
                );
        return rank = redisTemplate
                .opsForZSet()
                .rank(newProduct.getProductGroupId(), newProduct.getProductId())
                .intValue();

    }

}
