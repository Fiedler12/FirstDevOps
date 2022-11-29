package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "userdiseases")
@Getter
@Setter
@ToString
public class UserDisease {
    @EmbeddedId
    private UserDiseaseId userDiseaseId;
}