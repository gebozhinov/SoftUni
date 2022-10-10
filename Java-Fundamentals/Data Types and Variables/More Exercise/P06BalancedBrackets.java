import java.util.Scanner;

public class P06BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        byte n = Byte.parseByte(scanner.nextLine());

        byte openingBracket = 0;
        byte closingBracket = 0;
        String currentBracket = "";
        String lastBracket = "";
        boolean isBalanced = true;
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            if (input.charAt(0) == 40 && input.length() == 1 && currentBracket.equals("(")) {
                isBalanced = false;
                break;
            }
            if (input.charAt(0) == 40 && input.length() == 1) {
                openingBracket++;
                currentBracket = "(";
                lastBracket = "(";
            } else if (input.charAt(0) == 41 && input.length() == 1) {
                closingBracket++;
                currentBracket = ")";
                lastBracket = ")";
            }

        }
        if (!isBalanced || openingBracket != closingBracket || lastBracket.equals("(")) {
            System.out.println("UNBALANCED");
        } else {
            System.out.println("BALANCED");
        }

    }
}
