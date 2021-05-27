package org.launchcode.practicehub.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
public class Player extends AbstractEntity {

    private String name;

    private Double currentMonthCredits = 0.0;

    @OneToOne
    @Valid
    @NotNull
    private User user;

    public Player(User user, String name) {
        this.name = name;
    }

    public Player(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCurrentMonthCredits() {
        return currentMonthCredits;
    }

    public void setCurrentMonthCredits(Double totalCredits) {
        this.currentMonthCredits = totalCredits;
    }

    @Override
    public String toString() {
        return name;
    }
}
