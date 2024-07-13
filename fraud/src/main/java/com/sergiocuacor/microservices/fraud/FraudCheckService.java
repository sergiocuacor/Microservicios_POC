package com.sergiocuacor.microservices.fraud;


import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class FraudCheckService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public FraudCheckService(FraudCheckHistoryRepository fraudCheckHistoryRepository) {
        this.fraudCheckHistoryRepository = fraudCheckHistoryRepository;
    }

    public boolean isCustomerFraudulent(Integer customerId) {
        fraudCheckHistoryRepository.save(FraudCheckHistory.builder()
                .customerId(customerId)
                .isFraudster(false)
                .createdAt(LocalDateTime.now())
                .build());
        return false; // TODO: Buscar herramienta para verificar perfiles fraudulentos/ bots
    }
}
