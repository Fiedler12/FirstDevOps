package model;

import jakarta.persistence.*;

@Entity
@Table(name = "trial")
public class Trial {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;
}
