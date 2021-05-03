package org.launchcode.practicehub.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Practice extends AbstractEntity {

    private Date practiceDate;

    private Double numCredits;

    public Practice(Date practiceDate, Double numCredits) {
        this.practiceDate = practiceDate;
        this.numCredits = numCredits;
    }

    public Practice(){}

    public Date getPracticeDate() {
        return practiceDate;
    }

    public void setPracticeDate(Date practiceDate) {
        this.practiceDate = practiceDate;
    }

    public Double getNumCredits() {
        return numCredits;
    }

    public void setNumCredits(Double numCredits) {
        this.numCredits = numCredits;
    }
}
