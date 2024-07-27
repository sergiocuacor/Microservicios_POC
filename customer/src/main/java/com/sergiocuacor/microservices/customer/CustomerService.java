package com.sergiocuacor.microservices.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);


    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    public CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate) {
        this.customerRepository = customerRepository;
        this.restTemplate = restTemplate;
    }

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        customerRepository.saveAndFlush(customer);
        logger.info("Customer saved to DB: {}", customer);

        //TODO: Checkear si el email es válido
        //TODO: Checkear si el email no está en uso
        //TODO: Guardar customer en bd
        //TODO: Checkear si el customer es fraudulento
        logger.info("Attempting fraud check for customer ID: {}", customer.getId());
        FraudCheckResponse fraudCheckResponse =  restTemplate.getForObject(
                "http://FRAUD/api/v1/fraud-check/{customerId}",
                    FraudCheckResponse.class,
                customer.getId()
                ); // Gracias al service discovery de Eureka podemos quitar el puerto del localhost y poner solo el nombre del microservicio (localhost:8081 por FRAUD)
        logger.info("Fraud check response: {}", fraudCheckResponse);
        if(fraudCheckResponse.getIsFraudster()&& fraudCheckResponse != null){
            throw new IllegalStateException("fraudster");
        }

        logger.info("Customer registration completed successfully");
        //TODO: Enviar notificación

    }
}
