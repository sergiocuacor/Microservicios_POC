package com.sergiocuacor.microservices.verifier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(
        basePackages = "com.sergiocuacor.microservices.clients"
        // especificamos donde se encuentran las interfaces del FeignClient
)
public class VerifierApplication {
    public static void main(String[] args) {
        SpringApplication.run(VerifierApplication.class, args);
    }
}
