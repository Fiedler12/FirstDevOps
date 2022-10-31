package model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "trial")
@Getter
@Setter
@Builder
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Trial {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "disease")
    private String disease;

}
