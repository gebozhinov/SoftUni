import java.util.Scanner;

public class MovieDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int shootingTime = Integer.parseInt(scanner.nextLine());
        int scenes = Integer.parseInt(scanner.nextLine());
        int sceneTime = Integer.parseInt(scanner.nextLine());

        double shootingTimeWithoutPreparation = shootingTime - (shootingTime * 0.15);
        double totalSceneTime = scenes * sceneTime;

        double diff = Math.round(shootingTimeWithoutPreparation - totalSceneTime);
        if (shootingTimeWithoutPreparation >= totalSceneTime) {
            System.out.printf("You managed to finish the movie on time! You have %.0f minutes left!", diff);
        } else {
            System.out.printf("Time is up! To complete the movie you need %.0f minutes.", Math.abs(diff));
        }
    }
}
