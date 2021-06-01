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
    private LocalDate date;

    private Double numCredits;

    @ManyToOne
    @NotNull(message = "Skater required")
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

    public static ArrayList<Practice> searchBySkaterName(String skaterName, Iterable<Practice> allPractices) {
        String lowerName = skaterName.toLowerCase();
        ArrayList<Practice> results = new ArrayList<>();

        for (Practice practice : allPractices) {

            if (practice.getUser().getSkaterName().contains(lowerName)) {
                results.add(practice);
            }

        }
        return results;

    }
}
