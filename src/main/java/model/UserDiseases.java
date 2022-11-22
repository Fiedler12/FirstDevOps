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
    @OneToOne
    @JoinColumn(name = "disease")
    private Disease disease;

    @Id
    @OneToOne
    @JoinColumn(name = "user")
    private User user;


}
