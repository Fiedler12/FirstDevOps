package model;

import jakarta.persistence.*;
import lombok.*;

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
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "companyid")
    private int companyid;
    @Column(name = "trialname")
    private String trialname;

    //from table companies
    @Column(name = "cname")
    private String company;

    @Column(name = "location")
    private String location;

    @Column(name = "description")
    private String description;

}
