package bg.softuni.mobilelele.domain.dto.model;

import bg.softuni.mobilelele.domain.entities.User;
import bg.softuni.mobilelele.domain.enums.Role;

import java.util.Set;


public class UserRoleModel {

    private String id;
    private Role role;

    private Set<User> users;

    public UserRoleModel() {}

    public String getId() {
        return id;
    }

    public UserRoleModel setId(String id) {
        this.id = id;
        return this;
    }

    public Role getRole() {
        return role;
    }

    public UserRoleModel setRole(Role role) {
        this.role = role;
        return this;
    }

    public Set<User> getUsers() {
        return users;
    }

    public UserRoleModel setUsers(Set<User> users) {
        this.users = users;
        return this;
    }
}
