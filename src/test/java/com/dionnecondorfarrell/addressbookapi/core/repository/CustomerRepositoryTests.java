package com.dionnecondorfarrell.addressbookapi.core.repository;

import com.dionnecondorfarrell.addressbookapi.core.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CustomerRepositoryTests {

    @Autowired
    CustomerRepository customerRepository;

    List<Customer> customers;

    @BeforeEach
    public void setup() {

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
    public void test_retrieving_all_customers() {

       final List<Customer> actualCustomers = customerRepository.findAll();

       assertThat(actualCustomers).isNotNull();
       assertThat(actualCustomers).containsAll(asList(customers.get(0), customers.get(1)));
    }
}
