package com.dionnecondorfarrell.addressbookapi.web;


import com.dionnecondorfarrell.addressbookapi.core.GetCustomersUseCase;
import com.dionnecondorfarrell.addressbookapi.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class CustomerControllerTest {

    private CustomerController customerController;
    private GetCustomersUseCase getCustomersUseCase;

    @BeforeEach
    public void setup() {
        getCustomersUseCase = mock(GetCustomersUseCase.class);
        customerController = new CustomerController(getCustomersUseCase);
    }

    @Test
    public void test_retrieves_list_of_customers() {
        //arrange
        List<Customer> expectedCustomers = new ArrayList<>();

        final Customer customer1 = Customer.builder()
                .firstName("Patricia")
                .surname("Farrell")
                .id("pat@dcfhosting.co.uk")
                .address("123 Anywhere Street")
                .postCode("E17 6PP")
                .build();

        final Customer customer2 = Customer.builder()
                .firstName("Karen")
                .surname("Powell")
                .id("karen@dcfhosting.co.uk")
                .address("345 Anywhere Street")
                .postCode("E17 3AE")
                .build();

        final Customer customer3 = Customer.builder()
                .firstName("Sidney")
                .surname("Portier")
                .id("sidney@dcfhosting.co.uk")
                .address("678 Anywhere Street")
                .postCode("E17 6AA")
                .build();

        when(getCustomersUseCase.execute()).thenReturn(expectedCustomers);

        expectedCustomers.add(customer1);
        expectedCustomers.add(customer2);
        expectedCustomers.add(customer3);

        //act
        List<Customer> customers = customerController.getCustomers();

        //assert
        assertThat(customers.size()).isEqualTo(expectedCustomers.size());
        assertThat(customers.get(0).getSurname()).isEqualTo("Portier");
    }
}
