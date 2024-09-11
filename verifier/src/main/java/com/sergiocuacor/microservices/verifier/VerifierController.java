package com.sergiocuacor.microservices.verifier;


import com.sergiocuacor.microservices.clients.verifier.VerifierCheckResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/verifier-check")
public class VerifierController {

    private static final Logger log = LoggerFactory.getLogger(VerifierController.class);

    private final VerifierCheckService verifierCheckService;

    public VerifierController(VerifierCheckService verifierCheckService){

        this.verifierCheckService= verifierCheckService;

    }

    @GetMapping(path = "{customerId}")
    public VerifierCheckResponse isValid(@PathVariable("customerId") Integer customerId){
    boolean isCustomerValid = verifierCheckService.isCustomerValid(customerId);
    log.info("Verifier check request for customer {}", customerId);
    return new VerifierCheckResponse(isCustomerValid);
    }

}
