import java.util.Scanner;

public class P12EvenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int evenNumber = scanner.nextInt();

        while (evenNumber % 2 != 0) {
            System.out.println("Please write an even number.");
            evenNumber = scanner.nextInt();
        }
        System.out.printf("The number is: %d", Math.abs(evenNumber));
    }
}
