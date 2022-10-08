import java.util.Scanner;

public class LowerOrUpper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        char input = scanner.nextLine().charAt(0);

        if ('a' <= input && input <= 'z') {
            System.out.print("lower-case");
        } else {
            System.out.println("upper-case");
        }


    }
}
