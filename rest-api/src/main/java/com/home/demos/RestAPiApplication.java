package com.home.demos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@SpringBootApplication
@RestController
public class RestAPiApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestAPiApplication.class, args);
    }

    @GetMapping("/api/{id}")
    public String apiMethod(@PathVariable("id") String id) {
        if (new Random().nextBoolean()) {
            throw new RuntimeException("Some random exception");
        }

        return String.format("API response for %s!%n", id);
    }
}