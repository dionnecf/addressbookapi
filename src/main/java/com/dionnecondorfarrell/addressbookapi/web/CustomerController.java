package com.dionnecondorfarrell.addressbookapi.web;

import com.dionnecondorfarrell.addressbookapi.core.GetCustomersUseCase;
import com.dionnecondorfarrell.addressbookapi.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerController {
    public CustomerController(GetCustomersUseCase getCustomersUseCase) {
    }

    public List<Customer> getCustomers() {
        return new ArrayList<>();
    }
}
