package model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "subscribe")
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
public class Subscribe {
    @Id
    @OneToOne
    @JoinColumn(name = "trial_id")
    private Trial trial;

    @Id
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
