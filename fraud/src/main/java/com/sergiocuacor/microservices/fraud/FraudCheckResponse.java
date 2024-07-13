package com.sergiocuacor.microservices.fraud;

public class FraudCheckResponse {

    private final Boolean isFraudster;

    public FraudCheckResponse(Boolean isFraudster) {
        this.isFraudster = isFraudster;
    }
}
