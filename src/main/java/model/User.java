package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS")//WATCH out  USER is a reserved name!
@Getter
@Setter
@Builder
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "cpr")
    private int cpr;
    @Column @JsonIgnore
    private String hash;

    @ManyToMany
    @JoinTable(name = "userDiseases",
        joinColumns = {@JoinColumn(name = "user_id")},
        inverseJoinColumns = {@JoinColumn(name = "disease_id")})
    List<Disease> diseases = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "subscriptions",
        joinColumns = {@JoinColumn(name = "user_id")},
        inverseJoinColumns = {@JoinColumn(name = "trial_id")})
    List<Trial> subscriptions = new ArrayList<>();

    public User(int id, String email, String s) {
        this.id = id;
        this.email = email;
        this.password = s;
    }
}