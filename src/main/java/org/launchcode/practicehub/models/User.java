package org.launchcode.practicehub.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends AbstractEntity {

    @NotNull
    private String username;

    @NotNull
    private String pwHash;

    @NotNull
    private String skaterName;

    private double currentMonthCredits = 0.0;

    @OneToMany(mappedBy = "user")
    private List<Practice> practices = new ArrayList<>();

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User() {}

    public User(String username, String password, String skaterName) {
        this.username = username;
        this.pwHash = encoder.encode(password);
        this.skaterName = skaterName;
    }

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

    public String getUsername() {
        return username;
    }

//    public Player getPlayer() {
//        return player;
//    }
//
//    public void setPlayer(Player player) {
//        this.player = player;
//    }
}
