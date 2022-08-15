package com.justony.fraud.controller;


import com.justony.fraud.dto.FraudResponse;
import com.justony.fraud.service.FraudHistoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/fraud")
@AllArgsConstructor
@Slf4j(topic = "Fraud microservice: ")
public class FraudHistoryController {

    private final FraudHistoryService fraudService;

    @GetMapping("{customerId}")
    public FraudResponse isFraudster(@PathVariable("customerId") Integer customerId) {
        boolean isFraudulentCustomer = fraudService.isFraudulentCustomer(customerId);
        log.info("check customer fraud: {}", customerId);
        return new FraudResponse(isFraudulentCustomer);
    }

}
