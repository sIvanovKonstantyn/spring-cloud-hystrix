package com.home.demos;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(
        name = "rest-api"
        ,
        url = "http://localhost:9090"
//        ,
//        fallback = FeignClientFallback.class
)
public interface FeignClientExample {
    @RequestMapping("/api/{id}")
    String apiMethod(@PathVariable("id")  String id);
}
