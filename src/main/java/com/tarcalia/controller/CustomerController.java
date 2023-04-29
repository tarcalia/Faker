package com.tarcalia.controller;

import com.tarcalia.model.Customer;
import com.tarcalia.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for {@link Customer} entities.
 */
@RestController
public class CustomerController {
    @Autowired
    private CustomerService service;

    @GetMapping("/customers")
    public Iterable<Customer> getCustomers() {
        return service.findAll();
    }

    @PostMapping("/create")
    public Customer createCustomers(@RequestBody Customer customer) {
        return service.createCustomer(customer);
    }

    @GetMapping("/generate/{multiplier}")
    public List<Customer> generateCustomers(@PathVariable Integer multiplier) {
        return service.generateCustomers(multiplier);
    }
}