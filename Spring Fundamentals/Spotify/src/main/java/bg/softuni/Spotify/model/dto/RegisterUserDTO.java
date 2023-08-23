package bg.softuni.Spotify.model.dto;

import bg.softuni.Spotify.model.validation.EqualPassword;
import bg.softuni.Spotify.model.validation.UniqueData;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@EqualPassword
public class RegisterUserDTO {

    @UniqueData(fieldName = "username", message = "Username is already in use.")
    @NotBlank(message = "Username should not be blank.")
    @Size(min = 3, max = 20, message = "Username should be between 3 and 20 characters.")
    private String username;
    @UniqueData(fieldName = "email", message = "Email is already in use.")
    @NotBlank(message = "Email should not be blank.")
    @Email(message = "Provide valid email address.")
    private String email;
    @NotBlank(message = "Password should not be blank.")
    @Size(min = 3, max = 20, message = "Password should be between 3 and 20 characters.")
    private String password;
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public RegisterUserDTO setUsername(String username) {
        this.username = username;
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
