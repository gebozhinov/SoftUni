package entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "visitations")
public class Visitation extends BaseEntity{
    @Column(nullable = false)
    private Date date;
    @Column(length = 1000)
    private String comment;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Patient patient;

    protected Visitation() {}
    public Visitation(Date date) {
        this();
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
