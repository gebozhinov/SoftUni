package bg.softuni.Mobilelele.model.entity;

import bg.softuni.Mobilelele.model.entity.enums.Role;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class UserRoleEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column
    private Role role;

    public Role getRole() {
        return role;
    }

    public UserRoleEntity setRole(Role role) {
        this.role = role;
        return this;
    }
}
