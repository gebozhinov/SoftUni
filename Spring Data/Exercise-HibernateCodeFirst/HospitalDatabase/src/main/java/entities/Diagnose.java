package entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "diagnoses", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Diagnose extends BaseEntity {
    @Column(nullable = false, name = "name")
    private String name;
    @Column(length = 1000)
    private String comment;
    @ManyToMany(mappedBy = "diagnoses")
    private Set<Patient> patient;
    protected Diagnose() {
        this.patient = new HashSet<>();
    }
    public Diagnose(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Set<Patient> getPatient() {
        return patient;
    }

    public void setPatient(Set<Patient> patient) {
        this.patient = patient;
    }
}
