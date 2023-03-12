package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Table;

@Entity
@Table(name = "colors")
public class Color extends BaseEntity {

    @Column(nullable = false)
    private String name;

    public Color() {}

}
