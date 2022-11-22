package model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "Companies")
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

    @Column(name = "Email")
    private String email;

    @Column(name = "Companyname")
    private String companyName;
}
