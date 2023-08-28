package bg.softuni.ShoppingList.model.validation;

import bg.softuni.ShoppingList.repository.ProductRepository;
import bg.softuni.ShoppingList.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueDataValidator implements ConstraintValidator<UniqueData, String> {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private String fieldName;

    public UniqueDataValidator(UserRepository userRepository,
                               ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
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
            case "name" -> this.productRepository.findByName(value).isEmpty();
            default -> false;
        };

    }
}
