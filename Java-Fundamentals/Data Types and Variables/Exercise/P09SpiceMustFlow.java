import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int yield = Integer.parseInt(scanner.nextLine());
        int spice = 0;
        int days = 0;
        while (yield >= 100) {
            days++;
            spice += yield;
            yield -= 10;
            if (spice >= 26) {
                spice -= 26;
            } else {
                spice = 0;
            }
        }
        if (spice >= 26) {
            spice -= 26;
        } else {
            spice = 0;
        }
        System.out.println(days);
        System.out.println(spice);

    }
}
