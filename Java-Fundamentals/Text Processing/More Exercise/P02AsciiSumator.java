import java.util.Scanner;

public class P02AsciiSumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char firstSymbol = scanner.nextLine().charAt(0);
        char secondSymbol = scanner.nextLine().charAt(0);
        String input = scanner.nextLine();
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if (symbol > firstSymbol && symbol < secondSymbol) {
                sum += symbol;
            }
        }
        System.out.println(sum);
    }
}
