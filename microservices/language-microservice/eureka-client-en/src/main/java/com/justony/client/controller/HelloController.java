package com.justony.client.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@AllArgsConstructor
@Slf4j(topic = "Hello in English")
public class HelloController {
    private final RestTemplate restTemplate;
    private final EurekaClient discoveryClient;

    @GetMapping("hello/{message}")
    public String hello(@PathVariable("message") String message) {
        return String.format("Hi %s, I made a microservice, and that all:)", message);
    }

    @GetMapping("hello/rus/{message}")
    public String multipleHello(@PathVariable("message") String message) {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("client-rus", false);
        log.info(instance.getHomePageUrl());
        String response = restTemplate.getForObject(instance.getHomePageUrl() + "privet/" + message, String.class);
        return hello(message) + " <--> Russian says: " + response;
    }
}