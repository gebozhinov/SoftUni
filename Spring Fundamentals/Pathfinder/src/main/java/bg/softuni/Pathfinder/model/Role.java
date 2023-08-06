package bg.softuni.Pathfinder.model;

import bg.softuni.Pathfinder.model.enums.UserRole;
import jakarta.persistence.*;


@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Enumerated(EnumType.STRING)
    private UserRole role;

    public Long getId() {
        return id;
    }

    public Role setId(Long id) {
        this.id = id;
        return this;
    }

    public UserRole getRole() {
        return role;
    }

    public Role setRole(UserRole role) {
        this.role = role;
        return this;
    }
}
