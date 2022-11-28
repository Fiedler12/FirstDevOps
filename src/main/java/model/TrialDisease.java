package model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "trialdiseases")
@Getter
@Setter
@ToString
public class TrialDisease {
    @EmbeddedId
    private TrialDiseaseId trialDiseaseId;
}
