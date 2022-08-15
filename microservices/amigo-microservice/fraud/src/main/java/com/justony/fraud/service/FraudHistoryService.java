package com.justony.fraud.service;

import com.justony.fraud.dto.FraudHistory;
import com.justony.fraud.repo.FraudHistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudHistoryService {

    private final FraudHistoryRepository fraudRepository;

    public boolean isFraudulentCustomer(Integer customerId) {
        fraudRepository.save(FraudHistory.builder()
                        .isFraudster(false)
                        .customerId(customerId)
                        .createdAt(LocalDateTime.now())
                        .build());
        return false;
    }


}
