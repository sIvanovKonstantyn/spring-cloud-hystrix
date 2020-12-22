package com.home.demos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootApplication
@EnableCircuitBreaker
@EnableFeignClients
public class FeignClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignClientApplication.class, args);
    }

    @Bean
    public String callResult(FeignClientExample feignClientExample) throws InterruptedException {

        String result = null;

        for (int i = 0; i < 10; i++) {
            result = feignClientExample.apiMethod(UUID.randomUUID().toString());
            System.out.println(
                    String.format(
                            "%s: %s",
                            LocalDateTime.now(),
                            result
                    )
            );
        }

        return result;
    }
}