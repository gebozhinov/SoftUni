package bg.softuni.Battleships.model.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = UniqueDataValidator.class)
public @interface UniqueData {

    String fieldName();
    String message( ) default "";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
