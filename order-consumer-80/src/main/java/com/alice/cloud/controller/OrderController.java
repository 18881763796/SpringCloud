package com.alice.cloud.controller;

import com.alice.cloud.entities.CommonRuselt;
import com.alice.cloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final String URL = "http://localhost:8081";

    @Resource
    RestTemplate restTemplate;

    @GetMapping("/queryPayMent/{id}")
    public CommonRuselt<Payment> queryPayMent(@PathVariable  Long id){
        return restTemplate.getForObject(URL+"/payMent/queryPayMent/"+id, CommonRuselt.class);
    }
}
