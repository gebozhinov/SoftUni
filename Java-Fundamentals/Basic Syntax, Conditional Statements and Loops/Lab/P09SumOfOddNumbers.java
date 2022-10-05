import java.util.Scanner;

public class P09SumOfOddNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int sum = 0;
        int oddNumber = 1;
        for (int i = 0; i < n; i++) {
            System.out.println(oddNumber);
            sum += oddNumber;
            oddNumber += 2;
        }
        System.out.printf("Sum: %d", sum);


    }
}
