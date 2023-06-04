package bg.softuni.mobilelele.domain.dto;

import bg.softuni.mobilelele.domain.dto.model.UserRoleModel;

import java.util.UUID;

public class LoggedUser {

    private UUID id;
    private String username;
    private UserRoleModel roleModel;

    public LoggedUser() {}

    public UUID getId() {
        return id;
    }

    public LoggedUser setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public LoggedUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserRoleModel getRoleModel() {
        return roleModel;
    }

    public LoggedUser setRoleModel(UserRoleModel roleModel) {
        this.roleModel = roleModel;
        return this;
    }

    public void clearField() {
        this.id = null;
        this.username = null;
        this.roleModel = null;
    }
}
