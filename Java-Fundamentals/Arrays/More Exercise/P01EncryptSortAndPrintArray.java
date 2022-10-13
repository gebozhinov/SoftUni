import java.util.Arrays;
import java.util.Scanner;

public class P01EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            int sum = 0;
            for (int j = 0; j < input.length(); j++) {
                char letter = input.charAt(j);
                if ("AEIOUaeiou".indexOf(letter) != -1) {
                    sum += letter * input.length();
                } else {
                    sum += letter / input.length();

                }
            }
            numbers[i] = sum;
        }
        Arrays.sort(numbers);
        for (int i = 0; i < n; i++) {
            System.out.println(numbers[i]);
        }
    }
}
