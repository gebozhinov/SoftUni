import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());
        int tank = 0;
        for (int i = 0; i < lines; i++) {
            int quantities = Integer.parseInt(scanner.nextLine());
            if (tank + quantities > 255) {
                System.out.println("Insufficient capacity!");
                continue;
            }
            tank += quantities;
        }
        System.out.println(tank);

    }
}
