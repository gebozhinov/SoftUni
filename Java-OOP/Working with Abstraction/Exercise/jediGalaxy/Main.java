package workingWithAbstraction.exercise.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = getPosition(scanner.nextLine());
        int rows = dimensions[0];
        int cols = dimensions[1];

        Field galaxyField = new Field(rows, cols);
        Galaxy galaxy = new Galaxy(galaxyField);

        String command = scanner.nextLine();
        long collectedStars = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] jediPosition = getPosition(command);
            int[] evilPosition = getPosition(scanner.nextLine());
            int evilRow = evilPosition[0];
            int evilCol = evilPosition[1];

            galaxy.moveEvil(evilRow, evilCol);

            int jediRow = jediPosition[0];
            int jediCol = jediPosition[1];

            collectedStars = galaxy.moveJedi(collectedStars, jediRow, jediCol);

            command = scanner.nextLine();
        }

        System.out.println(collectedStars);


    }

    private static int[] getPosition(String scanner) {
        return Arrays.stream(scanner.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

}
