import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hallCapacity = Integer.parseInt(scanner.nextLine());
        int totalVisitors = 0;
        int income = 0;
        while (hallCapacity >= totalVisitors) {
            try {
                int visitors = Integer.parseInt(scanner.nextLine());
                totalVisitors += visitors;
                if (totalVisitors > hallCapacity) {
                    System.out.println("The cinema is full.");
                    break;
                }
                income += visitors * 5;
                if (visitors % 3 == 0) {
                    income -= 5;
                }
            } catch (Exception ex) {
                break;
            }
        }
        if (totalVisitors <= hallCapacity) {
            System.out.printf("There are %d seats left in the cinema.%n", hallCapacity - totalVisitors);
        }

        System.out.printf("Cinema income - %d lv.", income);
    }
}
