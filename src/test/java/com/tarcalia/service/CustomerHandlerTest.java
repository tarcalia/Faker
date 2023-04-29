package com.tarcalia.service;

import com.tarcalia.model.Customer;
import com.tarcalia.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * Unit tests for {@link CustomerHandler} class.
 */
class CustomerHandlerTest {
    @Mock
    private CustomerRepository repository;

    @InjectMocks
    private CustomerHandler underTest;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("GenerateCustomers")
    @Test
    void generateCustomers() {
        //given
        int expected = 3;
        when(repository.save(any())).thenReturn(new Customer());
        //when
        List<Customer> result = underTest.generateCustomers(expected);
        //then
        assertEquals(result.size(), expected);
    }
}