package com.example.usersystem.anotations.password;

import com.example.usersystem.constants.Constants;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class PasswordValidator implements ConstraintValidator<Password, CharSequence> {

    private static final Pattern PATTERN_LOWER = Pattern.compile("[a-z]");
    private static final Pattern PATTERN_UPPER = Pattern.compile("[A-Z]");
    private static final Pattern PATTERN_DIGIT = Pattern.compile("[0-9]");
    private static final Pattern PATTERN_SYMBOL = Pattern.compile("[!@#$%^&*()_+<>?]");

    private int minLength;
    private int maxLength;
    private boolean hasUpper;
    private boolean hasLower;
    private boolean hasDigit;
    private boolean hasSpecialSymbol;

    @Override
    public void initialize(Password password) {
        this.minLength = password.minLength();
        this.maxLength = password.maxLength();
        this.hasUpper = password.hasUpper();
        this.hasLower = password.hasLower();
        this.hasDigit = password.hasDigit();
        this.hasSpecialSymbol = password.hasSpecialSymbol();
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        if (value == null) {
            context.buildConstraintViolationWithTemplate(Constants.PASSWORD_CANNOT_BE_NULL).addConstraintViolation();
            return false;
        }
        if (value.length() < this.minLength) {
            context.buildConstraintViolationWithTemplate(Constants.PASSWORD_TOO_SHORT).addConstraintViolation();
            return false;
        }
        if (value.length() > this.maxLength) {
            context.buildConstraintViolationWithTemplate(Constants.PASSWORD_TOO_LONG).addConstraintViolation();
            return false;
        }

        String password = value.toString();

        if (!PATTERN_LOWER.matcher(password).find() && this.hasLower) {
            context.buildConstraintViolationWithTemplate(Constants.PASSWORD_CONTAINS_LOWERCASE_LETTER).addConstraintViolation();
            return false;
        }
        if (!PATTERN_UPPER.matcher(password).find() && this.hasUpper) {
            context.buildConstraintViolationWithTemplate(Constants.PASSWORD_CONTAINS_UPPERCASE_LETTER).addConstraintViolation();
            return false;
        }
        if (!PATTERN_DIGIT.matcher(password).find() && this.hasDigit) {
            context.buildConstraintViolationWithTemplate(Constants.PASSWORD_CONTAINS_DIGIT).addConstraintViolation();
            return false;
        }
        if (!PATTERN_SYMBOL.matcher(password).find() && this.hasSpecialSymbol) {
            context.buildConstraintViolationWithTemplate(Constants.PASSWORD_CONTAINS_SPECIAL_SYMBOL).addConstraintViolation();
            return false;
        }
        return true;
    }
}
