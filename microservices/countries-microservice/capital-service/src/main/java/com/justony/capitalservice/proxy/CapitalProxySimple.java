package com.justony.capitalservice.proxy;

import com.justony.capitalservice.dto.CapitalBean;
import com.justony.capitalservice.proxy.CapitalProxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "simpleFeign", url = "http://localhost:8080")
public interface CapitalProxySimple {
    @GetMapping("/{country}")
    public CapitalBean getCountry(@PathVariable("country") String country);
}
