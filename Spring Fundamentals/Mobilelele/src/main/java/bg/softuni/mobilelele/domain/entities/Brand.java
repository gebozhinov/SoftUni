package bg.softuni.mobilelele.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.Set;

@Table(name = "brands")
@Entity
public class Brand extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;
    @Column
    private LocalDateTime created;
    @Column
    private LocalDateTime modified;

    @OneToMany(targetEntity = Model.class, mappedBy = "brand")
    private Set<Model> models;
    public Brand() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public Set<Model> getModels() {
        return models;
    }

    public void setModels(Set<Model> models) {
        this.models = models;
    }
}
