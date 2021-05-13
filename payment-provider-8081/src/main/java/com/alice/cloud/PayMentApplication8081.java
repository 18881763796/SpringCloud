package com.alice.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PayMentApplication8081 {
    public static void main(String[] args) {
        SpringApplication.run(PayMentApplication8081.class);
    }
}
