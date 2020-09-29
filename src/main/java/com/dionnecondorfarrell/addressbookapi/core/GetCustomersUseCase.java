package com.dionnecondorfarrell.addressbookapi.core;

import com.dionnecondorfarrell.addressbookapi.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetCustomersUseCase {

    private CustomerRepository customerRepository;

    public GetCustomersUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomer(String surname) {
        return customerRepository.getBySurname(surname);
    }
}
