package bg.softuni.Spotify.model.validation;

import bg.softuni.Spotify.model.dto.RegisterUserDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EqualPasswordValidator implements ConstraintValidator<EqualPassword, RegisterUserDTO> {
    @Override
    public boolean isValid(RegisterUserDTO value, ConstraintValidatorContext context) {
        return value.getPassword().equals(value.getConfirmPassword());
    }
}
