package com.tarcalia.controller;

import com.tarcalia.model.Customer;
import com.tarcalia.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller for {@link Customer} entities.
 */
@RestController("/customer")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @GetMapping("/list")
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