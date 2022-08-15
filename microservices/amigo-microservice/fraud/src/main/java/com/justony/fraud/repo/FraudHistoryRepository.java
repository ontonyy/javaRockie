package com.justony.fraud.repo;

import com.justony.fraud.dto.FraudHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudHistoryRepository extends JpaRepository<FraudHistory, Integer> {
}
