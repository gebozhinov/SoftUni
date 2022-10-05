import java.util.Scanner;

public class P07TheatrePromotion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeOfDay = scanner.nextLine();
        int age = scanner.nextInt();

        int price = 0;
        boolean flag = false;

        switch (typeOfDay) {
            case "Weekday":
                if (0 <= age && age <= 18) {
                    price = 12;
                } else if (18 < age && age <= 64) {
                    price = 18;
                } else if (64 < age && age <= 122) {
                    price = 12;
                } else {
                    flag = true;
                }
                break;
            case "Weekend":
                if (0 <= age && age <= 18) {
                    price = 15;
                } else if (18 < age && age <= 64) {
                    price = 20;
                } else if (64 < age && age <= 122) {
                    price = 15;
                } else {
                    flag = true;
                }
                break;
            case "Holiday":
                if (0 <= age && age <= 18) {
                    price = 5;
                } else if (18 < age && age <= 64) {
                    price = 12;
                } else if (64 < age && age <= 122) {
                    price = 10;
                } else {
                    flag = true;
                }
                break;
        }
        if (!flag) {
            System.out.printf("%d$", price);
        } else {
            System.out.println("Error!");
        }

    }
}
