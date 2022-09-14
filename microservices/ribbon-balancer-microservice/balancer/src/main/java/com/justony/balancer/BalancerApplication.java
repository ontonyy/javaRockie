package com.justony.balancer;

import com.justony.balancer.config.RibbonConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RibbonClient(name = "chatbook", configuration = RibbonConfig.class)
@RestController
@Slf4j(topic = "Balancer")
public class BalancerApplication {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/invoke")
    public String invoke() {
        log.info("INSIDE HERE");
        return restTemplate.getForObject("http://chatbook/chatbook/chat", String.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(BalancerApplication.class, args);
    }
}
