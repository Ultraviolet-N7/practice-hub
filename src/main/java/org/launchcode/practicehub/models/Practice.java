package org.launchcode.practicehub.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;


@Entity
public class Practice extends AbstractEntity {


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Practice date is required")
    private LocalDate date;

    @NotNull(message = "Number of practice credits required")
    private Double numCredits;

    @ManyToOne
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static ArrayList<Practice> searchBySkaterName(String name, Iterable<Practice> allPractices) {
        ArrayList<Practice> results = new ArrayList<>();


        for (Practice practice : allPractices) {
            String lowerName = practice.getUser().getSkaterName().toLowerCase();
            if (lowerName.contains(name.toLowerCase())) {
                results.add(practice);
            }

        }
        return results;

    }
}
