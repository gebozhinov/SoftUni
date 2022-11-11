import java.util.Scanner;

public class P01ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        for (String s : input) {
            if (isUsernameValid(s)) {
                System.out.println(s);
            }
        }

        
    }

    public static boolean isUsernameValid(String user) {

        if (user.length() < 3 || user.length() > 16) {
            return false;
        }
        for (int i = 0; i < user.toCharArray().length; i++) {
            char symbol = user.charAt(i);
            if (!Character.isLetterOrDigit(symbol) && symbol != '-' && symbol != '_') {
                return false;
            }
        }
        return true;
    }
}
