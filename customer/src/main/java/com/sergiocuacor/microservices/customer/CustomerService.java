package com.sergiocuacor.microservices.customer;


import com.sergiocuacor.microservices.clients.verifier.VerifierCheckResponse;
import com.sergiocuacor.microservices.clients.verifier.VerifierClient;
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
    private final VerifierClient verifierClient;
    private final NotificationClient notificationClient;

    public CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate, VerifierClient verifierClient, NotificationClient notificationClient) {
        this.customerRepository = customerRepository;
        this.restTemplate = restTemplate;
        this.verifierClient = verifierClient;
        this.notificationClient = notificationClient;
    }

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        customerRepository.saveAndFlush(customer);

        VerifierCheckResponse verifierCheckResponse = verifierClient.isValid(customer.getId());

        if (!verifierCheckResponse.isValid()) {
            throw new IllegalStateException("Customer didn't pass the verifier check");
        }

        notificationClient.sendNotification(
                new NotificationRequest(customer.getId(), customer.getEmail(), "Welcome, " + customer.getFirstName() + " !")
        );


        logger.info("Customer registration completed successfully");
        //TODO: Enviar notificación

    }
}
