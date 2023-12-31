package com.example.redispractice_ec.service;

import com.example.redispractice_ec.dto.Product;
import com.example.redispractice_ec.dto.ProductGroup;
import io.lettuce.core.dynamic.domain.Timeout;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
        
        //-----------------연습

        // 집합에 멤버 추가
        redisTemplate.opsForSet().add("mySet", "member1");
        redisTemplate.opsForSet().add("mySet", "member2");
        redisTemplate.opsForHash().put("productHash", "field", "value");

        long timeOut = 1;

        // 키 삭제 시간 설정
        redisTemplate.expire("mySet", timeOut, TimeUnit.MINUTES);

        
        //----------------연습
        
        
        
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

    public int setNewProductGroup(ProductGroup productGroup){
        List<Product> productList = productGroup.getProductList();
        String productId = productList.get(0).getProductId();
        int price = productList.get(0).getPrice();
        redisTemplate.opsForZSet().add(productGroup.getProductGroupId(), productId, price);

        return redisTemplate.opsForZSet().zCard(productGroup.getProductGroupId()).intValue();
    }

    public int setNewProductGroupKeyword(String keyword, String prodId, double score){
        int rank = 0;
        redisTemplate.opsForZSet().add(keyword, prodId, score);
        rank = redisTemplate.opsForZSet().rank(keyword, prodId).intValue();
        return rank;
    }



}
