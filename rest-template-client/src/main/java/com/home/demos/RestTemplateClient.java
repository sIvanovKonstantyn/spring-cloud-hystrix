package com.home.demos;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateClient {
    @HystrixCommand(fallbackMethod = "defaultResponse")
    public String apiMethod(String id) {
        return new RestTemplate()
                .getForObject("http://localhost:9090/api/{id}",
                        String.class, id);
    }

    private String defaultResponse(String id) {
        return String.format("Response from circuit breaker for %s!", id);
    }
}
