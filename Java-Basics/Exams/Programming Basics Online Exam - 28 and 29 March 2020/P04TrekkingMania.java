import java.util.Scanner;

public class TrekkingMania {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int groups = Integer.parseInt(scanner.nextLine());

        int allPeople = 0;
        int musala = 0;
        int monblan = 0;
        int kilimanjaro = 0;
        int k2 = 0;
        int everest = 0;
        for (int i = 0; i < groups; i++) {
            int people = Integer.parseInt(scanner.nextLine());
            allPeople += people;
            if (people <= 5) {
                musala += people;
            } else if (people <= 12) {
                monblan += people;
            } else if (people <= 25) {
                kilimanjaro += people;
            } else if (people <= 40) {
                k2 += people;
            } else {
                everest += people;
            }
        }
        double musalaPercent = musala * 1.0 / allPeople * 100;
        double monblanPercent = monblan * 1.0 / allPeople * 100;
        double kilimanjaroPercent = kilimanjaro * 1.0 / allPeople * 100;
        double kwPercent = k2 * 1.0 / allPeople * 100;
        double everestPercent = everest * 1.0 / allPeople * 100;

        System.out.printf("%.2f%%%n", musalaPercent);
        System.out.printf("%.2f%%%n", monblanPercent);
        System.out.printf("%.2f%%%n", kilimanjaroPercent);
        System.out.printf("%.2f%%%n", kwPercent);
        System.out.printf("%.2f%%%n", everestPercent);

    }
}
