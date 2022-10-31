package model;

import jakarta.persistence.*;


@Entity
@Table(name = "company")
public class Company {
    @Id @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;
}
