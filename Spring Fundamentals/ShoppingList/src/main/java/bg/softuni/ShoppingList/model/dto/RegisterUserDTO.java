package bg.softuni.ShoppingList.model.dto;

import bg.softuni.ShoppingList.model.validation.EqualPassword;
import bg.softuni.ShoppingList.model.validation.UniqueData;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@EqualPassword
public class RegisterUserDTO {

    @UniqueData(fieldName = "username", message = "This username is already taken.")
    @Size(min = 3, max = 20, message = "Username should be between 3 and 20 characters.")
    @NotBlank(message = "Username should not be blank.")
    private String username;
    @UniqueData(fieldName = "email", message = "Email is already in use.")
    @Email(message = "Please provide valid email address.")
    @NotBlank(message = "Email should not be blank.")
    private String email;
    @Size(min = 3, max = 20, message = "Password should be between 3 and 20 characters.")
    @NotBlank(message = "Password should not be blank.")
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
