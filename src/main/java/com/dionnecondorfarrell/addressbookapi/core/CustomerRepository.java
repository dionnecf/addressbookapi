package com.dionnecondorfarrell.addressbookapi.core;

import com.dionnecondorfarrell.addressbookapi.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository {

    List<Customer> findAll();

    Customer getBySurname(String surname);
}
