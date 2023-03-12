package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "competition_type")
public class CompetitionType extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private CompetitionTypeValues type;
    public CompetitionType() {}
}
