package com.home.demos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootApplication
@EnableCircuitBreaker
public class RestTemplateClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestTemplateClientApplication.class, args);
    }

    @Bean
    public String callResult(RestTemplateClient restTemplateClient) throws InterruptedException {

        String result = null;

        for (int i = 0; i < 10; i++) {
            result = restTemplateClient.apiMethod(UUID.randomUUID().toString());
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