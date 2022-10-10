import java.util.Scanner;

public class P02FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String leftString = input.substring(0, input.indexOf(" "));
            String rightString = input.substring(input.indexOf(" ") + 1);
            long leftNumbers = Long.parseLong(leftString);
            long rightNumbers = Long.parseLong(rightString);
            long maxNum = Math.max(leftNumbers, rightNumbers);
            long sum = 0;
            while (maxNum != 0) {
                sum += maxNum % 10;
                maxNum /= 10;
            }
            System.out.println(Math.abs(sum));

        }
    }
}
