package com.tarcalia.service;

import com.github.javafaker.Faker;
import com.tarcalia.model.Customer;
import com.tarcalia.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service for {@link Customer} entities.
 */
@Service
public class CustomerHandler implements CustomerService {
    private final Logger logger = LoggerFactory.getLogger(CustomerHandler.class);
    @Autowired
    private CustomerRepository repository;
    private final Faker faker = new Faker();

    @Override
    public List<Customer> findAll() {
        logger.info("Customer findAll called");
        return repository.findAll();
    }

    @Override
    public Customer createCustomer(Customer customer) {
        logger.info("Customer create called" + customer);
        return repository.save(customer);
    }

    @Override
    public List<Customer> generateCustomers(Integer multiplier) {
        List<Customer> result = new ArrayList<>();
        for (int i = 0; i < multiplier; i++) {
            Customer newCustomer = fakeCustomer();
            result.add(newCustomer);
            repository.save(newCustomer);
        }
        return result;
    }

    private Customer fakeCustomer() {
        Customer newCustomer = new Customer();
        newCustomer.setName(faker.name().fullName());
        newCustomer.setEmail(faker.name().username() + "@email.com");
        newCustomer.setAge((int) (Math.random() * 99) + 1);
        logger.info("Customer generated" + newCustomer);
        return newCustomer;
    }
}
