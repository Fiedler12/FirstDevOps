package model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "TRIALS")
@Getter
@Setter
@Builder
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Trial{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "company")
    private Company company;

    @Column(name = "trialname")
    private String trialname;

    @Column(name = "location")
    private String location;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "TrialDiseases")
    private List<Disease> diseases;

    @OneToMany(mappedBy = "subscribe")
    private List<User> users;

}
