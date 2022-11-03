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
    @Id @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "cname")
    private String cname;
}
