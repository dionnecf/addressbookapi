package com.dionnecondorfarrell.addressbookapi.core;

import com.dionnecondorfarrell.addressbookapi.core.model.Customer;
import com.dionnecondorfarrell.addressbookapi.core.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetCustomersUseCase {

    @Autowired
    private CustomerRepository customerRepository;

    public GetCustomersUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomer(String surname) {
        return customerRepository.findBySurname(surname);
    }
}
