package com.example.usersystem.anotations.password;

import com.example.usersystem.constants.Constants;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Password {
    String message() default Constants.INVALID_PASSWORD_FORMAT;
    int minLength() default 4;
    int maxLength() default 30;

    boolean hasUpper() default false;
    boolean hasLower() default false;
    boolean hasDigit() default false;
    boolean hasSpecialSymbol() default false;

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
