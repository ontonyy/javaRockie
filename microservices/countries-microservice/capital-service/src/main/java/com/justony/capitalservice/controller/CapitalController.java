package com.justony.capitalservice.controller;

import com.justony.capitalservice.dto.CapitalBean;
import com.justony.capitalservice.proxy.CapitalProxy;
import com.justony.capitalservice.proxy.CapitalProxySimple;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@Slf4j(topic = "Capital Controller")
public class CapitalController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private CapitalProxy proxy;
    @Autowired
    private CapitalProxySimple simpleProxy;
    private Map<Integer, Integer> ips = new LinkedHashMap<>();

    @GetMapping("/{country}")
    public CapitalBean getCountry(@PathVariable String country) {
        CapitalBean response = proxy.getCountry(country);
        int port = response.getPort();
        ips.put(port, ips.getOrDefault(port, 0) + 1);
        log.info("CapitalService -> {}", response);
        return response;
    }

    @GetMapping("/ports")
    public String getCountryUsingFeign() {
        StringBuffer response=new StringBuffer();
        ips.forEach((k,v) -> response.append(" Port: "+k+" Value: "+v));
        return response.toString();
    }

    @GetMapping("/template/{country}")
    public CapitalBean getCountryUsingRestTemplate(@PathVariable String country) {

        Map<String, String> uriVariables = new LinkedHashMap<>();
        uriVariables.put("country", country);

        ResponseEntity<CapitalBean> responseEntity = restTemplate.getForEntity(
                "http://localhost:8080/{country}",
                CapitalBean.class,
                uriVariables);

        return responseEntity.getBody();
    }


    @GetMapping("/feign/{country}")
    public CapitalBean getCountryUsingFeign(@PathVariable String country) {
        CapitalBean response = simpleProxy.getCountry(country);
        return response;
    }
}
