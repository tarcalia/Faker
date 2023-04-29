package com.tarcalia.service;

import com.tarcalia.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service interface for {@link Customer} entities.
 */
public interface CustomerService {

    /**
     * Return a list of all {@link Customer}s.
     * @return
     */
    List<Customer> findAll();

    /**
     * Save a {@link Customer} into the repository.
     * @param customer will be saved.
     * @return the saved entity.
     */
    Customer createCustomer(Customer customer);

    /**
     * Generate N number of {@link Customer} entities.
     * @param multiplier represent how many entity will be generated.
     * @return the list of generated entities.
     */
    List<Customer> generateCustomers(Integer multiplier);
}
