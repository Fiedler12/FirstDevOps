package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
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
    @Column(name = "Name")
    private String name;
    @Column(name = "Email")
    private String email;
    @Column(name = "Password")
    private String password;
    @Column(name = "Salt")
    private String salt;
    @Column(name = "Privilege")
    private String privilege;
    @OneToMany(mappedBy = "disease")
    private List<UserDiseases> userDiseases;


    public User(int id, String email, String s) {
        this.id = id;
        this.email = email;
        this.password = s;
    }
}