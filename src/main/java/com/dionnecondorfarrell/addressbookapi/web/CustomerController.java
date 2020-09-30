package com.dionnecondorfarrell.addressbookapi.web;

import com.dionnecondorfarrell.addressbookapi.core.model.Customer;
import com.dionnecondorfarrell.addressbookapi.core.GetCustomersUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

@RestController
@RequestMapping(value="/addressbookapi")
public class CustomerController {

    @Autowired
    private GetCustomersUseCase getCustomersUseCase;

    public CustomerController(GetCustomersUseCase getCustomersUseCase) {
        this.getCustomersUseCase = getCustomersUseCase;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/customers", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Customer> getCustomers() {
        return getCustomersUseCase.getCustomers();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/customers/{surname}", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public Customer getCustomer(@PathVariable String surname) {
        return getCustomersUseCase.getCustomer(surname);
    }
}
