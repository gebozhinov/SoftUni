import java.util.Arrays;
import java.util.Scanner;

public class EasterEggs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int redEggs = 0;
        int orangeEggs = 0;
        int blueEggs = 0;
        int greenEggs = 0;
        int eggs = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < eggs; i++) {
            String eggColor = scanner.nextLine();
            switch (eggColor) {
                case "red":
                    redEggs++;
                    break;
                case "orange":
                    orangeEggs++;
                    break;
                case "blue":
                    blueEggs++;
                    break;
                case "green":
                    greenEggs++;
                    break;
            }
        }
        int[] maxColoredEggs = {redEggs, orangeEggs, blueEggs, greenEggs};
        String mostUsedColor = "";
        if (redEggs > (Math.max(orangeEggs, Math.max(blueEggs, greenEggs)))) {
            mostUsedColor = "red";
        } else if (orangeEggs > (Math.max(redEggs, Math.max(blueEggs, greenEggs)))) {
            mostUsedColor = "orange";
        } else if (blueEggs > (Math.max(redEggs, Math.max(orangeEggs, greenEggs)))) {
            mostUsedColor = "blue";
        } else {
            mostUsedColor = "green";
        }
        System.out.printf("Red eggs: %d%n", redEggs);
        System.out.printf("Orange eggs: %d%n", orangeEggs);
        System.out.printf("Blue eggs: %d%n", blueEggs);
        System.out.printf("Green eggs: %d%n", greenEggs);
        System.out.printf("Max eggs: %d -> %s",Arrays.stream(maxColoredEggs).max().getAsInt(), mostUsedColor);

    }
}
