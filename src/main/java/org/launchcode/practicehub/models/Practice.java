package org.launchcode.practicehub.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Entity
public class Practice extends AbstractEntity {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    private Double numCredits;

    @ManyToOne
    //@NotNull(message = "Test message")
    private Player player;

    public Practice(LocalDate practiceDate, Double numCredits, Player player) {
        this.date = practiceDate;
        this.numCredits = numCredits;
        this.player = player;
    }

    public Practice(){}

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getNumCredits() {
        return numCredits;
    }

    public void setNumCredits(Double numCredits) {
        this.numCredits = numCredits;
    }

    public Player getPlayer() {
        return player;
    }

}
