import java.util.Scanner;

public class BirthdayParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double rent = Double.parseDouble(scanner.nextLine());

        double cake = rent * 0.2;
        double drinks = cake * 0.55;
        double animator = rent / 3;

        double expenses = rent + cake + drinks + animator;
        System.out.printf("%.2f", expenses);

    }
}
