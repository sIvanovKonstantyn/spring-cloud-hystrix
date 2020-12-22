package com.home.demos;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FeignClientFallback implements FeignClientExample {
    @Override
    public String apiMethod(String id) {
        System.out.printf("%s: call with id: %s%n", LocalDateTime.now(), id);
        return String.format("Response from circuit breaker for %s!", id);
    }
}
