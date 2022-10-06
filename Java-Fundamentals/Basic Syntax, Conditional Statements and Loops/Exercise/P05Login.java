import java.util.Scanner;

public class P05Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String username = scanner.nextLine();
        String password = "";
        for (int i = username.length() - 1; i >= 0; i--) {
            char letter = username.charAt(i);
            password += letter;
        }

        String guessPassword = scanner.nextLine();
        int tries = 0;
        while (!guessPassword.equals(password)) {
            tries++;
            if (tries == 4) {
                System.out.printf("User %s blocked!", username);
                break;
            }
            System.out.println("Incorrect password. Try again.");

            guessPassword = scanner.nextLine();
        }
        if (guessPassword.equals(password)) {
            System.out.printf("User %s logged in.", username);
        }
    }
}
