package model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tag")//WATCH out  USER is a reserved name!
@Getter
@Builder
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Tag {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
}
