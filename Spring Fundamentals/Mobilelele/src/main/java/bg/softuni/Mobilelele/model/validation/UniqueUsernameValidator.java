package bg.softuni.Mobilelele.model.validation;

import bg.softuni.Mobilelele.model.entity.UserEntity;
import bg.softuni.Mobilelele.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {


    private final UserRepository userRepository;

    public UniqueUsernameValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return this.userRepository.login(value).isEmpty();
    }
}
