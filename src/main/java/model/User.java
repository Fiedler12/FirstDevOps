package model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    @Column(name = "salt")
    private String salt;

    @Column(name = "privilege")
    private int privilege;

    @OneToMany(mappedBy = "userDiseaseId.user", fetch = FetchType.EAGER)
    private List<UserDisease> userDiseases = new ArrayList<>();

    public User(int id, String email, String s) {
        this.id = id;
        this.email = email;
        this.password = s;
    }
}