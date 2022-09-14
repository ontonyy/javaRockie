package com.justony.countriesservice.controller;

import com.justony.countriesservice.dto.Country;
import com.justony.countriesservice.exceptions.NotFoundException;
import com.justony.countriesservice.repo.CountriesRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Path;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class CountriesController {
    private Map<Integer, Integer> timePorts = new LinkedHashMap<>();
    @Autowired
    private CountriesRepository countriesRepository;
    @Autowired
    private Environment environment;

    @GetMapping("/{country}")
    public Country getCountry(@PathVariable("country") String country) {
        Country countryBean = countriesRepository.findById(country).orElseThrow(() -> new NotFoundException("Not found: " + country));
        int port = Integer.parseInt(environment.getProperty("local.server.port"));
        countryBean.setPort(port);
        int time = timePorts.getOrDefault(port, 0);
        if (time >= 0) {
            try {
                Thread.sleep(time);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return countryBean;
    }

    @GetMapping("/time/{time}")
    public int getTime(@PathVariable int time) {
        int port = Integer.parseInt(environment.getProperty("local.server.port")) ;
        timePorts.put(port, time);
        return time;
    }
}
