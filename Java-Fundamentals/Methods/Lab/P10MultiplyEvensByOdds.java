import java.util.Scanner;

public class P10MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int number = Integer.parseInt(scanner.nextLine());
        System.out.println(multiplyEvenSumByOddSum(number));


    }

    public static int multiplyEvenSumByOddSum(int number) {
        return evenSum(number) * oddSum(number);
    }

    public static int evenSum(int number) {
        int sum = 0;
        while (number != 0) {
            int currentNum = number % 10;
            if (currentNum % 2 == 0){
                sum += currentNum;
            }
            number /= 10;
        }
        return sum;
    }

    public static int oddSum(int number) {
        int sum = 0;
        while (number != 0) {
            int currentNum = number % 10;
            if (currentNum % 2 != 0){
                sum += currentNum;
            }
            number /= 10;
        }
        return sum;
    }
}
