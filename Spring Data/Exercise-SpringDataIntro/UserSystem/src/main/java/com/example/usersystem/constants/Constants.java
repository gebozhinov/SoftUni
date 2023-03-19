package com.example.usersystem.constants;

public enum Constants {
    ;
    public static final String INVALID_USERNAME_LENGTH = "Username must be between 4 and 30 symbols";
    public static final String INVALID_PASSWORD_FORMAT = "Invalid password format";
    public static final String PASSWORD_CANNOT_BE_NULL = "Password cannot be null";
    public static final String PASSWORD_TOO_SHORT = "Password must be more than 6 symbols";
    public static final String PASSWORD_TOO_LONG = "Password must NOT be more than 50 symbols";
    public static final String PASSWORD_CONTAINS_LOWERCASE_LETTER = "Password should contain at least one lowercase letter";
    public static final String PASSWORD_CONTAINS_UPPERCASE_LETTER = "Password should contain at least one uppercase letter";
    public static final String PASSWORD_CONTAINS_DIGIT = "Password should contain at least one digit";
    public static final String PASSWORD_CONTAINS_SPECIAL_SYMBOL = "Password should contain at least one special symbol " +
            "(!, @, #, $, %, ^, &, *, (, ), _, +, <, >, ?)";

    public static final String INVALID_EMAIL_FORMAT = "Invalid email format";

}
