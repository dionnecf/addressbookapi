package com.dionnecondorfarrell.addressbookapi.core;


import com.dionnecondorfarrell.addressbookapi.core.repository.CustomerRepository;
import com.dionnecondorfarrell.addressbookapi.core.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class GetCustomersUseCaseTests {

    private CustomerRepository customerRepository;
    private GetCustomersUseCase getCustomersUseCase;
    private List<Customer> customers;

    @BeforeEach
    public void setup() {
        customerRepository = mock(CustomerRepository.class);
        getCustomersUseCase = new GetCustomersUseCase(customerRepository);
        customers = new ArrayList<>();
        final Customer customer1 = Customer.builder()
                .firstName("Elaine")
                .surname("Condor")
                .id("elaine@dcfhosting.co.uk")
                .address("123 Anywhere Street")
                .postCode("E17 6PP")
                .build();

        final Customer customer2 = Customer.builder()
                .firstName("Karen")
                .surname("Staywell")
                .id("karenstaywell@dcfhosting.co.uk")
                .address("345 Anywhere Street")
                .postCode("E17 3AE")
                .build();

        customers.add(customer1);
        customers.add(customer2);
    }

    @Test
    public void test_invoke_the_repo_to_retrieve_customers() {

        when(customerRepository.findAll()).thenReturn(customers);

        List<Customer> actualCustomers = getCustomersUseCase.getCustomers();

        verify(customerRepository).findAll();
        assertThat(actualCustomers).isNotNull();
        assertThat(actualCustomers).isNotEmpty();
        assertThat(actualCustomers).contains(customers.get(0));
    }

    @Test
    public void test_invoke_the_repo_to_retrieve_customer_by_surname() {

        when(customerRepository.findBySurname("Staywell")).thenReturn(customers.get(1));

        Customer actualCustomer = getCustomersUseCase.getCustomer("Staywell");

        verify(customerRepository).findBySurname("Staywell");
        assertThat(actualCustomer).isNotNull();
        assertThat(actualCustomer.getSurname()).isEqualTo("Staywell");
    }
}
