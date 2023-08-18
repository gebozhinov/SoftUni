package bg.softuni.Battleships.model.validation;

import bg.softuni.Battleships.repository.ShipRepository;
import bg.softuni.Battleships.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueDataValidator implements ConstraintValidator<UniqueData, String> {

    private final UserRepository userRepository;
    private final ShipRepository shipRepository;
    private String fieldName;

    public UniqueDataValidator(UserRepository userRepository,
                               ShipRepository shipRepository) {
        this.userRepository = userRepository;
        this.shipRepository = shipRepository;
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
            case "name" -> this.shipRepository.findByName(value).isEmpty();
            default -> false;
        };

    }
}
