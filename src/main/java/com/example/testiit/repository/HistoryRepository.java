package com.example.testiit.repository;

import com.example.testiit.model.CoffeeMakerHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<CoffeeMakerHistory,Long> {
}
