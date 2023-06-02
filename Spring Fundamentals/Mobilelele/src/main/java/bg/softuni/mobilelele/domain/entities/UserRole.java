package bg.softuni.mobilelele.domain.entities;

import bg.softuni.mobilelele.domain.enums.Role;
import jakarta.persistence.*;

import java.util.Set;

@Table(name = "roles")
@Entity
public class UserRole extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(targetEntity = User.class, mappedBy = "role")
    private Set<User> users;

    public UserRole() {}

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
