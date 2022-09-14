package com.justony.balancer.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class RibbonConfig {
    @Autowired
    IClientConfig ribbonClient;

    @Bean
    public IPing ping(IClientConfig config) {
        return new PingUrl();
    }

    @Bean
    public IRule rule(IClientConfig config) {
        return new AvailabilityFilteringRule();
    }
}
