package com.dionnecondorfarrell.addressbookapi.core.repository;

import com.dionnecondorfarrell.addressbookapi.core.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findAll();

    Customer findBySurname(String surname);
}
