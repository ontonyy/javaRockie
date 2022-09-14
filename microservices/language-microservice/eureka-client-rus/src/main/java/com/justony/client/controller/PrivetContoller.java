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
@Slf4j(topic = "Privet in Russian")
public class PrivetContoller {
    private final RestTemplate restTemplate;
    private final EurekaClient discoveryClient;

    @GetMapping("privet/{message}")
    public String privet(@PathVariable("message") String message) {
        return String.format("Здарова %s, я микросервис создал, ура!", message);
    }

    @GetMapping("privet/en/{message}")
    public String multiplePrivet(@PathVariable("message") String message) {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("client-en", false);
        log.info(instance.getHomePageUrl());
        String response = restTemplate.getForObject(instance.getHomePageUrl() + "hello/" + message, String.class);
        return privet(message) + " <--> English says: " + response;
    }
}
