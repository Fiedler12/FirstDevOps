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
    private float id;
    @Column(name = "companyid")
    private int companyid;
    @Column(name = "trialname")
    private String trialname;

//    @Column(name = "company")
//    private String company;
//
//    @Column(name = "name")
//    private String name;
//
//    @Column(name = "location")
//    private String location;
//
//    @Column(name = "description")
//    private String description;

}
