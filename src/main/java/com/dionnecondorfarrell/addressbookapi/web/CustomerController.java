package com.dionnecondorfarrell.addressbookapi.web;

import com.dionnecondorfarrell.addressbookapi.core.GetCustomersUseCase;
import com.dionnecondorfarrell.addressbookapi.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private GetCustomersUseCase getCustomersUseCase;

    public CustomerController(GetCustomersUseCase getCustomersUseCase) {
        this.getCustomersUseCase = getCustomersUseCase;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value="/customers", produces = APPLICATION_JSON_VALUE)
    public List<Customer> getCustomers() {
        return getCustomersUseCase.getCustomers();
    }

    public Customer getCustomer(String surname) {
        return getCustomersUseCase.getCustomer(surname);
    }
}
