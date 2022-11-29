package model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Entity
@Table(name = "userdiseases")
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
public class UserDiseases {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name = "diseaseid")
    private Disease disease;

    @ManyToOne
    @JoinColumn(name="userid")
    private User user;


}
