package org.launchcode.practicehub.models;

import javax.persistence.Entity;
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
