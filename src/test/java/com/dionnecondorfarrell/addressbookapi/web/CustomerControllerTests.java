package com.dionnecondorfarrell.addressbookapi.web;


import com.dionnecondorfarrell.addressbookapi.core.GetCustomersUseCase;
import com.dionnecondorfarrell.addressbookapi.core.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;


public class CustomerControllerTests {

    private CustomerController customerController;
    private GetCustomersUseCase getCustomersUseCase;
    private List<Customer> expectedCustomers;

    @BeforeEach
    public void setup() {
        getCustomersUseCase = mock(GetCustomersUseCase.class);
        customerController = new CustomerController(getCustomersUseCase);

        expectedCustomers = new ArrayList<>();

        final Customer customer1 = Customer.builder()
                .firstName("Sharon")
                .surname("Stone")
                .id("sharon@dcfhosting.co.uk")
                .address("910 Anywhere Street")
                .postCode("E17 7TR")
                .build();

        final Customer customer2 = Customer.builder()
                .firstName("Samuel")
                .surname("Jackson")
                .id("samuel@dcfhosting.cco.uk")
                .address("109 Anywhere Street")
                .postCode("E17 6HH")
                .build();

        final Customer customer3 = Customer.builder()
                .firstName("Danny")
                .surname("Glover")
                .id("danny@dcfhosting.co.uk")
                .address("876 Anywhere Street")
                .postCode("E17 8RT")
                .build();

        expectedCustomers.add(customer1);
        expectedCustomers.add(customer2);
        expectedCustomers.add(customer3);
    }

    @Test
    public void test_retrieves_list_of_customers() {
        //arrange

        when(getCustomersUseCase.getCustomers()).thenReturn(expectedCustomers);

        //act
        List<Customer> customers = customerController.getCustomers();

        //assert
        verify(getCustomersUseCase).getCustomers();
        assertThat(customers).isNotNull();
        assertThat(customers).isNotEmpty();
        assertThat(customers.size()).isEqualTo(expectedCustomers.size());
        assertThat(customers.get(0).getSurname()).isEqualTo("Stone");
    }

    @Test
    public void test_retrieves_a_customer_by_surname() {

        when(getCustomersUseCase.getCustomer("Jackson")).thenReturn(expectedCustomers.get(1));

        Customer retrievedCustomer = customerController.getCustomer("Jackson");

        verify(getCustomersUseCase).getCustomer("Jackson");
        assertThat(retrievedCustomer).isNotNull();
        assertThat(retrievedCustomer.getSurname()).isEqualTo("Jackson");
        assertThat(retrievedCustomer.getFirstName()).isEqualTo("Samuel");
    }
}
