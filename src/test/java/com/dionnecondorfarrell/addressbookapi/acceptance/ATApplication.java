package com.dionnecondorfarrell.addressbookapi.acceptance;

import com.dionnecondorfarrell.addressbookapi.model.Customer;
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

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void return_a_list_of_customers_response() {
        final ResponseEntity<List<Customer>> response =
                restTemplate.exchange("/customers",
                        HttpMethod.GET, new HttpEntity<>(new HttpHeaders()),
                        new ParameterizedTypeReference<List<Customer>>() {
        });

        assertThat((response).getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().size()).isEqualTo(5);
    }

   @Test
    public void return_an_address_book_entry_by_surname_response() {
        ResponseEntity<Customer> response = restTemplate.getForEntity("/customers/Farrell", Customer.class);

        assertThat((response).getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(requireNonNull(response.getBody()).getSurname()).isEqualTo("Farrell");

    }
    //test call to api with not found response
}
