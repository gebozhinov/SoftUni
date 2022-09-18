import java.util.Scanner;

public class SleepyTomCat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int daysOff = Integer.parseInt(scanner.nextLine());

        int workDays = 365 - daysOff;
        int playingMinutes = (workDays * 63) + (daysOff * 127);
        int norm = Math.abs(30000 - playingMinutes);
        int hours = norm / 60;
        int minutes = norm % 60;

        if (playingMinutes > 30000) {
            System.out.println("Tom will run away");
            System.out.printf("%d hours and %d minutes more for play", hours, minutes);
        } else {
            System.out.println("Tom sleeps well");
            System.out.printf("%d hours and %d minutes less for play", hours, minutes);
        }
    }
}
