package com.sergiocuacor.microservices.customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerService{

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void registerCustomer(CustomerRegistrationRequest request){
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        //TODO: Checkear si el email es válido
        //TODO: Checkear si el email no está en uso
        //TODO: Guardar customer en bd

        customerRepository.save(customer);
    }
}
