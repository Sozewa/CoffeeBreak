package com.example.testiit.model;

import javax.persistence.*;


@Entity
public class CoffeeMaker {

    @Id
    @SequenceGenerator( name = "jpaSequenceMaker", sequenceName = "JPA_SEQUENCE_MAKER", allocationSize = 1, initialValue = 1 )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "jpaSequenceMaker")
    private Long id;

    private String name;

    private int waterLevel;

    private int heater;

    private boolean switcher;

    public CoffeeMaker() {
    }

    public CoffeeMaker(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isSwitcher() {
        return switcher;
    }

    public void setSwitcher(boolean switcher) {
        this.switcher = switcher;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(int waterLevel) {
        this.waterLevel = waterLevel;
    }

    public int getHeater() {
        return heater;
    }

    public void setHeater(int heater) {
        this.heater = heater;
    }
}
