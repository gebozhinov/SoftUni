package bg.softuni.Mobilelele.model.dto;

import bg.softuni.Mobilelele.model.validation.EqualPassword;
import bg.softuni.Mobilelele.model.validation.UniqueUsername;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@EqualPassword(message = "Passwords do not match.")
public class UserRegisterDTO {

    @NotEmpty
    @Size(min = 2, max = 20)
    private String firstName;
    @NotEmpty
    @Size(min = 2, max = 20)
    private String lastName;
    @NotEmpty(message = "Enter username.")
    @Size(min = 4, message = "Username should be at least 4 symbols.")
    @UniqueUsername
    private String username;
    @NotEmpty(message = "Password should not be empty.")
    @Size(min = 5, message = "Password must be at least 5 symbols.")
    private String password;


    private String confirmPassword;

    public String getFirstName() {
        return firstName;
    }

    public UserRegisterDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegisterDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterDTO setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterDTO setUsername(String username) {
        this.username = username;
        return this;
    }
}
