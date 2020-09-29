package com.dionnecondorfarrell.addressbookapi.web;

import com.dionnecondorfarrell.addressbookapi.core.GetCustomersUseCase;
import com.dionnecondorfarrell.addressbookapi.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerController {

    private GetCustomersUseCase getCustomersUseCase;

    public CustomerController(GetCustomersUseCase getCustomersUseCase) {
        this.getCustomersUseCase = getCustomersUseCase;
    }

    public List<Customer> getCustomers() {
        return getCustomersUseCase.getCustomers();
    }

    public Customer getCustomer(String poiter) {
        return null;
    }
}
