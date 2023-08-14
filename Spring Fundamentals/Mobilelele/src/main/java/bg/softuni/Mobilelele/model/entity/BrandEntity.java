package bg.softuni.Mobilelele.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "brands")
public class BrandEntity extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String name;
    @Column
    private LocalDate created;
    @Column
    private LocalDate modified;

    @OneToMany(targetEntity = ModelEntity.class, mappedBy = "brand")
    private Set<ModelEntity> models;

    public String getName() {
        return name;
    }

    public BrandEntity setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public BrandEntity setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public LocalDate getModified() {
        return modified;
    }

    public BrandEntity setModified(LocalDate modified) {
        this.modified = modified;
        return this;
    }

    public Set<ModelEntity> getModels() {
        return models;
    }

    public BrandEntity setModels(Set<ModelEntity> models) {
        this.models = models;
        return this;
    }
}
