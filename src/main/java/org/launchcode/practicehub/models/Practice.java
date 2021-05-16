package org.launchcode.practicehub.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import java.time.LocalDate;


@Entity
public class Practice extends AbstractEntity {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    private Double numCredits;

    public Practice(LocalDate practiceDate, Double numCredits) {
        this.date = practiceDate;
        this.numCredits = numCredits;
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


}
