package com.justony.currency.controller;

import com.justony.currency.dto.ExchangeValue;
import com.justony.currency.repo.ExchangeRepository;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/currency_exchange")
public class ExchangeController {
    private Environment environment;
    private ExchangeRepository exchangeRepository;

    @GetMapping("/{from}/{to}")
    public ExchangeValue retrieveExchange(@PathVariable("from") String from, @PathVariable("to") String to) {
        ExchangeValue exchangeValue = exchangeRepository.findByFromAndTo(from, to);
        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        return exchangeValue;
    }
}
