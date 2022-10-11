import java.util.Scanner;

public class P06EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] firstInputLine = scanner.nextLine().split(" ");
        String[] secondInputLine = scanner.nextLine().split(" ");

        int[] firstNumbers = new int[firstInputLine.length];
        int[] secondNumbers = new int[secondInputLine.length];

        boolean isIdentical = true;
        int sum = 0;
        for (int i = 0; i < firstInputLine.length; i++) {
            firstNumbers[i] = Integer.parseInt(firstInputLine[i]);
            secondNumbers[i] = Integer.parseInt(secondInputLine[i]);
            sum += firstNumbers[i];
            if (firstNumbers[i] != secondNumbers[i]) {
                System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                isIdentical = false;
                break;
            }
        }
        if (isIdentical) {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        }
    }
}
