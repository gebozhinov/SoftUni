package bg.softuni.Mobilelele.model.validation;

import bg.softuni.Mobilelele.model.dto.UserRegisterDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EqualPasswordValidator implements ConstraintValidator<EqualPassword, UserRegisterDTO> {



    @Override
    public boolean isValid(UserRegisterDTO value, ConstraintValidatorContext context) {


        return value.getPassword().equals(value.getConfirmPassword());
    }
}
