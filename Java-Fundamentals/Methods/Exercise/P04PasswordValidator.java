import java.util.Scanner;

public class P04PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String password = scanner.nextLine();

        if (isPasswordValid(password)) {
            System.out.println("Password is valid");
        }

    }

    public static boolean passwordLength(String password) {
        if (password.length() < 6 || password.length() > 10) {
            System.out.println("Password must be between 6 and 10 characters");
            return false;
        } else {
            return true;
        }
    }

    public static boolean passwordLettersAndDigits(String password) {
        for (int i = 0; i < password.length(); i++) {
            char symbol = password.charAt(i);
            if ((symbol < 65 || symbol > 122) && (symbol < 48 || symbol > 57)) {
                System.out.println("Password must consist only of letters and digits");
                return false;
            }
        }
        return true;
    }

    public static boolean passwordMustHaveTwoDigits(String password) {
        int countDigits = 0;
        for (int i = 0; i < password.length(); i++) {
            char symbol = password.charAt(i);
            if ((symbol >= 48 && symbol <= 57)) {
                countDigits++;
            }
        }
        if (countDigits < 2) {
            System.out.println("Password must have at least 2 digits");
            return false;
        } else {
            return true;
        }
    }
    public static boolean isPasswordValid(String password) {
        boolean isValid = true;
        if (!passwordLength(password)) {
            isValid = false;
        }
        if (!passwordLettersAndDigits(password)) {
            isValid = false;
        }
        if (!passwordMustHaveTwoDigits(password)){
            isValid = false;
        }
        return isValid;
    }
}
