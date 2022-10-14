import java.util.Scanner;

public class P04Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String action = scanner.nextLine();
        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        switch (action) {
            case "add":
                add(num1, num2);
                break;
            case "multiply":
                multiply(num1, num2);
                break;
            case "subtract":
                subtract(num1, num2);
                break;
            case "divide":
                divide(num1, num2);
                break;
        }

    }

    public static void add(int num1, int num2) {
        int result = num1 + num2;
        System.out.println(result);
    }

    public static void multiply(int num1, int num2) {
        int result = num1 * num2;
        System.out.println(result);
    }

    public static void subtract(int num1, int num2) {
        int result = num1 - num2;
        System.out.println(result);
    }

    public static void divide(int num1, int num2) {
        int result = num1 / num2;
        System.out.println(result);
    }
}
