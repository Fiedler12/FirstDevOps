package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "trialdisease")
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
public class TrialDiseases {
    @Id
    @OneToOne
    @JoinColumn(name = "trial")
    private Trial trial;

    @Id
    @OneToOne
    @JoinColumn
    private Disease disease;
}
