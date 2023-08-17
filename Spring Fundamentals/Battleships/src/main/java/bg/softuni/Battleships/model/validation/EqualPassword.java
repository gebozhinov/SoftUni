package bg.softuni.Battleships.model.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = EqualPasswordValidator.class)
public @interface EqualPassword {

    String message( ) default "";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
