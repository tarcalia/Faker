package com.tarcalia.controller;

import com.tarcalia.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.assertEquals;

/**
 * Controller tests for {@link Customer} entities.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
class CustomerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getCustomers() throws Exception {
        MvcResult mvcResult =  mockMvc.perform(MockMvcRequestBuilders.get("/customer/ist"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "adf");
    }

    @Test
    void createCustomers() {
    }

    @Test
    void generateCustomers() {
    }
}