package com.sergiocuacor.microservices.customer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    void testRegisterCustomer() throws Exception {
        CustomerRegistrationRequest request = new CustomerRegistrationRequest(
                "John Doe", "john@example.com", "123456789");

        doNothing().when(customerService).registerCustomer(any(CustomerRegistrationRequest.class));

        mockMvc.perform(post("/api/v1/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"John Doe\",\"email\":\"john@example.com\",\"phoneNumber\":\"123456789\"}"))
                .andExpect(status().isOk());

        verify(customerService, times(1)).registerCustomer(any(CustomerRegistrationRequest.class));
    }

    @Test
    void testRegisterCustomerWithInvalidRequest() throws Exception {
        mockMvc.perform(post("/api/v1/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"\",\"email\":\"\",\"phoneNumber\":\"\"}"))
                .andExpect(status().isBadRequest());

        verify(customerService, never()).registerCustomer(any(CustomerRegistrationRequest.class));
    }
}