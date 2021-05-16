package org.launchcode.practicehub.models;

import javax.persistence.Entity;

@Entity
public class Player extends AbstractEntity {

    private String name;

    private Double totalCredits;

    public Player(String name, Double totalCredits) {
        this.name = name;
        this.totalCredits = totalCredits;
    }

    public Player(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(Double totalCredits) {
        this.totalCredits = totalCredits;
    }

    @Override
    public String toString() {
        return name;
    }
}
