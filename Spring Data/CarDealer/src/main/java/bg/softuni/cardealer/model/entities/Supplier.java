package bg.softuni.cardealer.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "suppliers")
public class Supplier extends BaseEntity {
    @Column
    private String name;
    @Column(name = "is_importer")
    private boolean isImporter;
    @OneToMany(targetEntity = Part.class, mappedBy = "supplier", fetch = FetchType.EAGER)
    private Set<Part> parts;

    public Supplier() {
        this.parts = new HashSet<>();
    }

}
