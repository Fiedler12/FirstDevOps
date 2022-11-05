package model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "companies")
@Getter
@Setter
@Builder
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "companyname")
    private String companyName;
}
