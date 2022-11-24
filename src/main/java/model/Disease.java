package model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "diseases")
@Getter
@Setter
@Builder
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Disease {
    @Id
    @GeneratedValue
    @Column(name = "diseaseid")
    private int id;

    @Column(name = "name")
    private String name;
}
