package com.home.demos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableCircuitBreaker
@RestController
@EnableHystrixDashboard
public class RestTemplateClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestTemplateClientApplication.class, args);
    }


    @Autowired
    private RestTemplateClient restTemplateClient;

    @GetMapping("/api/{id}")
    public String apiMethod(@PathVariable("id") String id) {
        return restTemplateClient.apiMethod(id);
    }
}