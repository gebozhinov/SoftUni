package entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "medicament", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Medicament extends BaseEntity {
    @Column(nullable = false, name = "name")
    private String name;
    @ManyToMany(mappedBy = "medicament")
    private Set<Patient> patients;

    protected Medicament() {
        this.patients = new HashSet<>();
    }

    public Medicament(String name) {
        this();
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }
}
