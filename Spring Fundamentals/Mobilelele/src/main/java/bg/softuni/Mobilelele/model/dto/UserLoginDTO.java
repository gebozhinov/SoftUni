package bg.softuni.Mobilelele.model.dto;

public class UserLoginDTO {

    private String username;
    private String password;


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserLoginDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}
