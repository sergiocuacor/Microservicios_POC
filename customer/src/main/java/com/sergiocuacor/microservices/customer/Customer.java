package com.sergiocuacor.microservices.customer;

import lombok.Builder;
import lombok.Data;
// Arquitectura N capas


@Data
@Builder
public class Customer {
    private String id;
    private String firstName;
    private String lastName;
    private String email;

}

/* Funcionamiento de @Builder:
1. Nos genera una clase interna estática llamada CustomerBuilder:
public static class CustomerBuilder {
    private String id;
    private String firstName;
    private String lastName;
    private String email;

    CustomerBuilder() {
    }


    public CustomerBuilder id(String id) {
        this.id = id;
        return this;
    }

    public CustomerBuilder firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CustomerBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public CustomerBuilder email(String email) {
        this.email = email;
        return this;
    }

    public Customer build() {
        return new Customer(this);
    }
}

2. Añade un método estático builder() a la clase Customer:
public static CustomerBuilder builder() {
    return new CustomerBuilder();
}


3. Crea un constructor privado en Customer que acepta un CustomerBuilder:

private Customer(CustomerBuilder b) {
    this.id = b.id;
    this.firstName = b.firstName;
    this.lastName = b.lastName;
    this.email = b.email;
}

4. Modifica el constructor por defecto de Customer para que sea privado:

private Customer() {
}


*** Con estos cambios, ahora podemos crear objetos Customer así:

Customer customer = Customer.builder()
    .id("1")
    .firstName("Juan")
    .lastName("Pérez")
    .email("juan@ejemplo.com")
    .build();

 */