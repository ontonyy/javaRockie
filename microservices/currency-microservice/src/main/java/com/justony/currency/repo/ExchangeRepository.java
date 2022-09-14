package com.justony.currency.repo;

import com.justony.currency.dto.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRepository extends
        JpaRepository<ExchangeValue, Long>{
    ExchangeValue findByFromAndTo(String from, String to);
}