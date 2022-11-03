package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TRIALS")//WATCH out  USER is a reserved name!
@Getter
@Setter
@Builder
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Trialtest {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "companyid")
    private String companyid;
    @Column(name = "trialname")
    private String trialname;

}