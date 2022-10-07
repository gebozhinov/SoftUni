import java.util.Scanner;

public class P02EnglishNameOfTheLastDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int number = Integer.parseInt(scanner.nextLine());

        int lastDigit = number % 10;
        if (lastDigit == 0) {
            System.out.println("zero");
        } else {
            System.out.println(names[lastDigit - 1]);
        }

    }

    public static final String[] names = {"one", "two", "three", "four", "five", "six", "seven",
            "eight", "nine"};
}
