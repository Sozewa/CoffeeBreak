package com.example.testiit.model;

import javax.persistence.*;

@Entity
public class CoffeeMakerHistory {


    @Id
    @SequenceGenerator( name = "jpaSequenceHistory", sequenceName = "JPA_SEQUENCE_HISTORY", allocationSize = 1, initialValue = 1)
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "jpaSequenceHistory")
    @Column(name ="id")
    private Long id;

    @Column(name = "reports",columnDefinition = "varchar")
    private String reports;

    @ManyToOne
    @JoinColumn(name = "coffeeMakerId")
    private CoffeeMaker coffeeMaker;

    public CoffeeMakerHistory() {
    }

    public CoffeeMakerHistory(CoffeeMaker coffeeMaker) {
        this.coffeeMaker=coffeeMaker;
    }

    public String getReports() {
        return reports;
    }

    public void setReports(String reports) {
        this.reports = reports;
    }

    @Override
    public String toString() {
        return "CoffeeMakerHistory{" +
                "id=" + id +
                ", reports='" + reports + '\'' +
                '}';
    }
}
