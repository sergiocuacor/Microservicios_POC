package com.sergiocuacor.microservices.customer;

public record CustomerRegistrationRequest(String firstName, String lastName, String email) {


}
// Utilizada para realizar las peticiones HTTP para la creacion nuevos customers