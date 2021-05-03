package org.launchcode.practicehub.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.lang.Object;
import java.time.LocalDate;


@Entity
public class Practice extends AbstractEntity {

    private LocalDate practiceDate;

    private Double numCredits;

    public Practice(LocalDate practiceDate, Double numCredits) {
        this.practiceDate = practiceDate;
        this.numCredits = numCredits;
    }

    public Practice(){}

    public LocalDate getPracticeDate() {
        return practiceDate;
    }

    public void setPracticeDate(LocalDate practiceDate) {
        this.practiceDate = practiceDate;
    }

    public Double getNumCredits() {
        return numCredits;
    }

    public void setNumCredits(Double numCredits) {
        this.numCredits = numCredits;
    }
}
