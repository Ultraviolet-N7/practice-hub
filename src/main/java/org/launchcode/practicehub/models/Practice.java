package org.launchcode.practicehub.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Practice {

    @Id
    @GeneratedValue
    private int id;

    private int numCredits;

    // This will be an enum type
    // private PracticeType type;

    private Date practiceDate;


    public Practice(int numCredits) {
        this.numCredits = numCredits;
    }

    public Practice(){}

    public int getNumCredits() {
        return numCredits;
    }

    public void setNumCredits(int numCredits) {
        this.numCredits = numCredits;
    }

    public Date getPracticeDate() {
        return practiceDate;
    }

    public void setPracticeDate(Date practiceDate) {
        this.practiceDate = practiceDate;
    }
}
