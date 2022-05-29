package com.example.testiit.repository;

import com.example.testiit.model.CoffeeMaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeMakerRepo extends JpaRepository<CoffeeMaker,Long> {
}
