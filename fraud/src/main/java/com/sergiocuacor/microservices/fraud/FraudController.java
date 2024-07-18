package com.sergiocuacor.microservices.fraud;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
public class FraudController {

    private static final Logger log = LoggerFactory.getLogger(FraudController.class);

    private final FraudCheckService fraudCheckService;

    public FraudController(FraudCheckService fraudCheckService){
        this.fraudCheckService= fraudCheckService;
    }

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId){
    boolean isCustomerFraudulent = fraudCheckService.isCustomerFraudulent(customerId);
    log.info("Fraud check request for customer {}", customerId);
    return new FraudCheckResponse(isCustomerFraudulent);
    }

}
