package com.likebookapp.model.dto;

import com.likebookapp.util.validation.EqualPassword;
import com.likebookapp.util.validation.UniqueData;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@EqualPassword
public class RegisterUserDTO {

    @NotBlank(message = "Enter valid username.")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters.")
    @UniqueData(fieldName = "username", message = "Username is already taken.")
    private String username;

    @NotBlank(message = "Enter valid email.")
    @Email(message = "Enter valid email.")
    @UniqueData(fieldName = "email", message = "Email is already taken.")
    private String email;

    @NotBlank(message = "Enter strong password.")
    @Size(min = 3, max = 20, message = "Password must be between 3 and 20 characters.")
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
