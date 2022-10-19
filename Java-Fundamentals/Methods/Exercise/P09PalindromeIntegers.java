import java.util.Scanner;

public class P09PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        while (!input.equals("END")) {
            printPalindrome(input);
                
            input = scanner.nextLine();
        }

    }

    public static void printPalindrome(String number) {
        String backwardSpell = "";
        for (int i = number.length() - 1; i >= 0; i--) {
            backwardSpell += number.charAt(i);
        }
        if (backwardSpell.equals(number)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
