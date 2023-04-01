package bg.softuni.exercisespringdataautomappingobjects.model.dto;


import lombok.Getter;

import java.util.regex.Pattern;

import static bg.softuni.exercisespringdataautomappingobjects.Constant.Validation.*;

@Getter
public class RegisterUserDTO {

    private String email;
    private String password;
    private String confirmPassword;
    private String fullName;

    public RegisterUserDTO(String email, String password, String confirmPassword, String fullName) {
        setEmail(email);
        setPassword(password);
        setConfirmPassword(confirmPassword);
        setFullName(fullName);
    }

    private void setEmail(String email) {
        boolean isValid = Pattern.matches(EMAIL_VALIDATION, email);
        if (!isValid) {
            throw new IllegalArgumentException(EMAIL_NOT_VALID);
        }
        this.email = email;
    }

    private void setPassword(String password) {
        boolean isValid = Pattern.matches(PASSWORD_VALIDATION, password);
        if (!isValid) {
            throw new IllegalArgumentException(PASSWORD_NOT_VALID);
        }
        this.password = password;
    }

    private void setConfirmPassword(String confirmPassword) {
        if (!this.password.equals(confirmPassword)) {
            throw new IllegalArgumentException(PASSWORD_NOT_MATCH);
        }
        this.confirmPassword = confirmPassword;
    }

    private void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
