import java.util.Scanner;

public class P06StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int strongNumber = n;
        int sum = 0;
        while (n > 0) {
            int lastDigit = n % 10;
            int fact = 1;
            for (int i = 1; i <= lastDigit ; i++) {
                fact = fact * i;
                
            }
            sum += fact;
            n /= 10;
        }
        if (strongNumber == sum) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }




    }
}
