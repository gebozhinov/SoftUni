package bg.softuni.Battleships.model.dto;

import bg.softuni.Battleships.model.validation.EqualPassword;
import bg.softuni.Battleships.model.validation.UniqueData;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@EqualPassword
public class RegisterUserDTO {

    @Size(min = 3, max = 10, message = "Username should be between 3 and 10 characters.")
    @UniqueData(fieldName = "username", message = "Username is already in use.")
    private String username;
    @Size(min = 5, max = 20)
    private String fullName;
    @Email(message = "Incorrect email.")
    @UniqueData(fieldName = "email", message = "Email is already in use.")
    private String email;
    @Size(min = 3)
    private String password;
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public RegisterUserDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public RegisterUserDTO setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public RegisterUserDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegisterUserDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public RegisterUserDTO setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}

