package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class TrialDiseaseId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "diseaseid")
    private Disease disease;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "trialid")
    private Trial trial;
}



