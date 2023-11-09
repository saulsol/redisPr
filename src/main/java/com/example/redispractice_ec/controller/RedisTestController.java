package com.example.redispractice_ec.controller;

import com.example.redispractice_ec.dto.TestWord;
import com.example.redispractice_ec.service.RedisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
public class RedisTestController {

    private final RedisService redisService;

    @PostMapping("/redisTest")
    public void redisTestController(@RequestBody TestWord testWord){

        redisService.saveData("test", testWord.getWord());
        redisService.saveData("testObject", testWord);

        log.info("--------- {} ---------",  redisService.getData("test", String.class).get());
        log.info("--------- {} ---------",  redisService.getData("testObject", TestWord.class).get());

    }
}
