package com.sergiocuacor.microservices.clients.verifier;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("verifier")
public interface VerifierClient {
    @GetMapping(path = "api/v1/verifier-check/{customerId}")
    VerifierCheckResponse isValid(@PathVariable("customerId") Integer customerId);
}
