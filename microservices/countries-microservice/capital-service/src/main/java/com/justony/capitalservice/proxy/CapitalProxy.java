package com.justony.capitalservice.proxy;

import com.justony.capitalservice.dto.CapitalBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "countries-service")
public interface CapitalProxy {
    @GetMapping("/{country}")
    public CapitalBean getCountry(@PathVariable("country") String country);
}


