package bg.softuni.Spotify.model.validation;

import bg.softuni.Spotify.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueDataValidator implements ConstraintValidator<UniqueData, String> {

    private final UserRepository userRepository;
    private String fieldName;

    public UniqueDataValidator(UserRepository userController) {
        this.userRepository = userController;
    }

    @Override
    public void initialize(UniqueData constraintAnnotation) {
        this.fieldName = constraintAnnotation.fieldName();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return switch (fieldName) {
            case "username" -> this.userRepository.findByUsername(value).isEmpty();
            case "email" -> this.userRepository.findByEmail(value).isEmpty();
            default -> false;
        };
    }
}
