package bg.softuni.Battleships.model.validation;

import bg.softuni.Battleships.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueDataValidator implements ConstraintValidator<UniqueData, String> {

    private final UserRepository userRepository;
    private String fieldName;

    public UniqueDataValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void initialize(UniqueData constraintAnnotation) {
        this.fieldName = constraintAnnotation.fieldName();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (fieldName.equals("username")) {
            return this.userRepository.findByUsername(value).isEmpty();
        } else if (fieldName.equals("email")) {
            return this.userRepository.findByEmail(value).isEmpty();
        }

        return false;
    }
}
