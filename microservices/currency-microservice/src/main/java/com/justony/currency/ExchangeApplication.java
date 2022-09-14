package com.justony.currency;

import com.justony.currency.dto.ExchangeValue;
import com.justony.currency.repo.ExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@SpringBootApplication
public class ExchangeApplication implements CommandLineRunner {
	@Autowired
	private ExchangeRepository exchangeRepository;

	public static void main(String[] args) {
		SpringApplication.run(ExchangeApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	/*
		Add values to sql table.
	 */
	@Override
	public void run(String... args) throws Exception {
		exchangeRepository.save(new ExchangeValue(10001,"USD","INR",new BigDecimal(65),0));
		exchangeRepository.save(new ExchangeValue(10002,"EUR","INR",new BigDecimal(75),0));
		exchangeRepository.save(new ExchangeValue(10003,"AUD","INR",new BigDecimal(25),0));
	}
}
