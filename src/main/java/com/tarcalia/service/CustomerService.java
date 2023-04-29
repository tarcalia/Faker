package com.tarcalia.service;

import com.tarcalia.model.Customer;

import java.util.List;

/**
 * Service interface for {@link Customer} entities.
 */
public interface CustomerService {

    List<Customer> findAll();

    Customer createCustomer(Customer customer);

    List<Customer> generateCustomers(Integer multiplier);
}
