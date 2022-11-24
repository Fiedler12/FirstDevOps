package model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDiseaseId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "diseaseid")
    private Disease disease;

    @OneToOne
    @JoinColumn(name = "userid")
    private User user;
}
