package bg.softuni.mobilelele.domain.dto;

import bg.softuni.mobilelele.domain.entities.UserRole;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserRegisterDTO {

    @NotNull
    @Size(min = 2, max = 20)
    private String firstName;
    @NotNull
    @Size(min = 2, max = 20)
    private String lastName;
    @NotNull
    @Size(min = 5, max = 20)
    private String username;
    @NotNull
    @Size(min = 6, max = 50)
    private String password;

    @NotNull
    private String role;

    public UserRegisterDTO() {}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
