package com.example.usersystem.anotations.email;

import com.example.usersystem.constants.Constants;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class EmailValidator implements ConstraintValidator<Email, String> {

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^([a-zA-Z0-9_\\-.]+)@([a-zA-Z0-9_\\-]+)\\.([a-zA-Z]{2,5}){1,2}$");

    @Override
    public void initialize(Email email) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (!EMAIL_PATTERN.matcher(value).matches()) {
            context.buildConstraintViolationWithTemplate(Constants.INVALID_EMAIL_FORMAT);
            return false;
        }
        return true;
    }
}
