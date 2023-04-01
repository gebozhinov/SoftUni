package bg.softuni.exercisespringdataautomappingobjects.Constant;

public enum Validation {
    ;
    public static final String EMAIL_VALIDATION = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-]+)(\\.[a-zA-Z]{2,5}){1,2}$";
    public static final String PASSWORD_VALIDATION = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,}$";
    public static final String EMAIL_NOT_VALID = "Incorrect email.";

    public static final String PASSWORD_NOT_VALID = "Length must be at least 6 symbols " +
            "and must contain at least 1 uppercase, " +
            "1 lowercase letter and 1 digit.";
    public static final String INCORRECT_USERNAME_PASSWORD = "Incorrect username / password";
    public static final String PASSWORD_NOT_MATCH = "Password not match.";

    public static final String USER_REGISTERED = "%s was registered";

    public static final String SUCCESSFULLY_LOGGED = "Successfully logged in %s";

    public static final  String CANNOT_LOG_OUT = "Cannot log out. No user was logged in.";
    public static final String LOG_OUT = "User %s successfully logged out";
}
