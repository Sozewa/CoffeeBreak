package com.example.testiit.controller;

import com.example.testiit.model.CoffeeMaker;
import com.example.testiit.service.CoffeeMakerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(CoffeeMakerController.class)
@AutoConfigureMockMvc
class CoffeeMakerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CoffeeMaker maker;

    @MockBean
    private CoffeeMakerService service;

    @Test
    void switchCoffeeMaker() throws Exception {
        mockMvc.perform(get("/switcher?id=2"))
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    void addCoffeeMaker() throws Exception {
        mockMvc.perform(get("/add?name="))
                .andExpect(status().isOk()).andReturn();

    }

    @Test
    void getAllCoffeeMaker() throws Exception{
        mockMvc.perform(get("/getAll"))
                .andExpect(status().isOk());
    }

    @Test
    void getCoffeeMaker() throws Exception{
        mockMvc.perform(get("/getById?id=9"))
                .andExpect(status().isOk());
    }
}