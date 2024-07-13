package com.sergiocuacor.microservices.customer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void testCustomerBuilder() {
        Customer customer = Customer.builder()
                .id(1L)
                .firstName("Carlos")
                .lastName("Fuentes")
                .email("carlos.fuentes@gmail.com")
                .build();

        assertEquals(1L, customer.getId());
        assertEquals("Carlos", customer.getFirstName());
        assertEquals("Fuentes", customer.getLastName());
        assertEquals("carlos.fuentes@gmail.com", customer.getEmail());
    }

    @Test
    void testGettersYSetters() {
        Customer customer = new Customer();
        customer.setId(2L);
        customer.setFirstName("Jesus");
        customer.setLastName("Navas");
        customer.setEmail("jesus.navas@gmail.com");

        assertEquals(2L, customer.getId());
        assertEquals("Jesus", customer.getFirstName());
        assertEquals("Navas", customer.getLastName());
        assertEquals("jesus.navas@gmail.com", customer.getEmail());
    }

    @Test
    void testToString() {
        Customer customer = Customer.builder()
                .id(3L)
                .firstName("Rebecca")
                .lastName("Fergusson")
                .email("rebecca.fergusson@gmail.com")
                .build();

        String expectedString = "Customer{id=3, firstName='Rebecca', lastName='Fergusson', email='rebecca.fergusson@gmail.com'}";
        assertEquals(expectedString, customer.toString());
    }

    @Test
    void testConstructorVacio() {
        Customer customer = new Customer();
        assertNull(customer.getId());
        assertNull(customer.getFirstName());
        assertNull(customer.getLastName());
        assertNull(customer.getEmail());
    }

    @Test
    void testBuilderConValoresNulos() {
        Customer customer = Customer.builder().build();
        assertNull(customer.getId());
        assertNull(customer.getFirstName());
        assertNull(customer.getLastName());
        assertNull(customer.getEmail());
    }
}
