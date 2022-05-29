package com.example.testiit.service;

import com.example.testiit.Constant;
import com.example.testiit.model.CoffeeMaker;
import com.example.testiit.model.CoffeeMakerHistory;
import com.example.testiit.repository.CoffeeMakerRepo;
import com.example.testiit.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;

@Service
public class CoffeeMakerService implements Constant {

    @Autowired
    private CoffeeMakerRepo makerRepo;

    @Autowired
    private HistoryRepository history;

    Thread thread ;

    @Async
    public CoffeeMaker switcher(int id) {
        CoffeeMaker maker = makerRepo.findById(id).get();
        CoffeeMakerHistory makerHistory = new CoffeeMakerHistory(maker);

        if (maker.isSwitcher()) {
            maker.setSwitcher(false);
            maker.setWaterLevel(0);
            maker.setHeater(0);
            makerHistory.setReports(String.format(STOP_REPORT, Date.from(Instant.now())));
            thread.stop();
        } else {
            thread = new Thread(() -> heaterSwitch(maker));
            maker.setSwitcher(true);
            maker.setWaterLevel(100);
            maker.setHeater(100);
            makerHistory.setReports(String.format(START_REPORT, Date.from(Instant.now())));
            thread.start();
        }
        makerRepo.save(maker);
        history.save(makerHistory);


        return maker;
    }

    public Iterable<CoffeeMaker> getAll() {
        return makerRepo.findAll();
    }

    public CoffeeMaker add(String name) {
        return makerRepo.save(new CoffeeMaker(name));
    }

    @Async
    public void heaterSwitch(CoffeeMaker coffeeMaker) {

        if (!coffeeMaker.isSwitcher()) return;

        int waterLevel = coffeeMaker.getWaterLevel();
        while (waterLevel >= 0) {
            coffeeMaker.setWaterLevel(waterLevel);
            waterLevel -= 10;
            makerRepo.save(coffeeMaker);
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        coffeeMaker.setHeater(80);
        CoffeeMakerHistory makerHistory = new CoffeeMakerHistory(coffeeMaker);
        makerHistory.setReports(String.format(SET_TEMPERATURE, Date.from(Instant.now())));
        history.save(makerHistory);
    }

    public Optional<CoffeeMaker> getOne(int id) {
       return makerRepo.findById(id);
    }
}
