import java.util.Scanner;

public class P04TribonacciSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        if (num == 1) {
            System.out.println("1");
        } else {
            printTribonacciNumbers(num);
        }


    }

    public static void printTribonacciNumbers(int num) {
        int n1 = 0, n2 = 1, n3 = 1;
        int tribonacciNum;

        System.out.print(n2 + " " + n2 + " ");

        for (int i = 2; i < num; i++) {
            tribonacciNum = n1 + n2 + n3;
            System.out.print(tribonacciNum + " ");
            n1 = n2;
            n2 = n3;
            n3 = tribonacciNum;


        }
    }
}
