package com.dionnecondorfarrell.addressbookapi.acceptance;

import com.dionnecondorfarrell.addressbookapi.core.model.Customer;
import com.dionnecondorfarrell.addressbookapi.core.model.CustomerError;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.boot.test.web.client.TestRestTemplate;
import static java.util.Objects.requireNonNull;
import org.springframework.core.ParameterizedTypeReference;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ATApplication {

    //test call to api with positive response
    private static final String URL_CUSTOMERS = "/addressbookapi/customers";
    private static final String URL_CUSTOMER_BY_SURNAME = "/addressbookapi/customers/Farrell";
    private static final String URL_CUSTOMER_BY_NONE_EXISTENT_SURNAME = "/addressbookapi/customers/Smith";

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void return_a_list_of_customers_response() {
        final Customer customer1 = Customer.builder()
                .firstName("Elaine")
                .surname("Condor")
                .id("elaine@dcfhosting.co.uk")
                .address("123 Anywhere Street")
                .postCode("E17 6PP")
                .build();
        final ResponseEntity<List<Customer>> response =
                restTemplate.exchange(URL_CUSTOMERS,
                        HttpMethod.GET, new HttpEntity<>(new HttpHeaders()),
                        new ParameterizedTypeReference<List<Customer>>() {
        });

        assertThat((response).getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().size()).isEqualTo(5);
        assertThat(response.getBody().contains(customer1));
    }

   @Test
    public void return_an_address_book_entry_by_surname_response() {
        ResponseEntity<Customer> response = restTemplate.exchange(URL_CUSTOMER_BY_SURNAME, HttpMethod.GET,
                new HttpEntity<>(new HttpHeaders()), Customer.class);

        assertThat((response).getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(requireNonNull(response.getBody()).getSurname()).isEqualTo("Farrell");
    }

    @Test
    public void return_an_error_message_when_surname_not_found() {
        ResponseEntity<Customer> response = restTemplate.exchange(URL_CUSTOMER_BY_NONE_EXISTENT_SURNAME,
                HttpMethod.GET, new HttpEntity<>(new HttpHeaders()), Customer.class);

        assertThat((response).getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}
