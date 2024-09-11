package com.sergiocuacor.microservices.verifier;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class VerifierCheckService {

    private final VerifierCheckHistoryRepository verifierCheckHistoryRepository;

    public VerifierCheckService(VerifierCheckHistoryRepository verifierCheckHistoryRepository) {
        this.verifierCheckHistoryRepository = verifierCheckHistoryRepository;
    }

    public boolean isCustomerValid(Integer customerId) {
        verifierCheckHistoryRepository.save(VerifierCheckHistory.builder()
                .customerId(customerId)
                .isValid(true)
                .createdAt(LocalDateTime.now())
                .build());
        return true; // TODO: Buscar herramienta para verificar perfiles fraudulentos/ bots
    }
}
