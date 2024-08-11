package com.sergiocuacor.microservices.customer;

import com.sergiocuacor.microservices.clients.fraud.FraudCheckResponse;
import com.sergiocuacor.microservices.clients.fraud.FraudClient;
import com.sergiocuacor.microservices.clients.notifications.NotificationClient;
import com.sergiocuacor.microservices.clients.notifications.NotificationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;

    public CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate, FraudClient fraudClient, NotificationClient notificationClient) {
        this.customerRepository = customerRepository;
        this.restTemplate = restTemplate;
        this.fraudClient = fraudClient;
        this.notificationClient = notificationClient;
    }

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }

        notificationClient.sendNotification(
                new NotificationRequest(customer.getId(), customer.getEmail(), "Welcome, " + customer.getFirstName() + " !")
        );


        logger.info("Customer registration completed successfully");
        //TODO: Enviar notificación

    }
}
