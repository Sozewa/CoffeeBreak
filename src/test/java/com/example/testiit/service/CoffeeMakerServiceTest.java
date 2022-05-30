package com.example.testiit.service;



import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.example.testiit.model.CoffeeMaker;
import com.example.testiit.repository.CoffeeMakerRepo;
import com.example.testiit.repository.HistoryRepository;
import net.bytebuddy.dynamic.DynamicType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@EnableAsync
@AutoConfigureMockMvc
class CoffeeMakerServiceTest {

    @MockBean
    private CoffeeMakerRepo coffeeMakerRepo;

    @MockBean
    private HistoryRepository historyRepository;

    @MockBean
    private CoffeeMakerService service;

    @MockBean
    private CoffeeMaker maker;

    @Test
    void switcher() {
        when(service.switcher(maker.getId())).thenReturn(maker);
    }

    @Test
    void getAll() {
        when(service.getAll()).thenCallRealMethod();
    }

    @Test
    void add() {
        when(service.add(maker.getName())).thenReturn(maker);
    }

    @Test
    void getOne() {
        Optional<CoffeeMaker> mock = coffeeMakerRepo.findById(maker.getId());
        when(service.getOne(maker.getId())).thenReturn(mock);
    }
}