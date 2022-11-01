package model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "trial")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Trial {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "company")
    private String company;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "description")
    private String description;

}
