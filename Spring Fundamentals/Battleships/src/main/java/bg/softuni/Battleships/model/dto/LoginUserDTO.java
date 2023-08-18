package bg.softuni.Battleships.model.dto;

import jakarta.validation.constraints.Size;

public class LoginUserDTO {

    @Size(min = 3, max = 10)
    private String username;
    @Size(min = 3)
    private String password;

    public String getUsername() {
        return username;
    }

    public LoginUserDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginUserDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}
