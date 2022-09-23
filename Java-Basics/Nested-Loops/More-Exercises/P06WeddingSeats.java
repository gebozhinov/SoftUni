import java.util.Scanner;

public class WeddingSeats {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String lastSector = scanner.nextLine();
        int rows = Integer.parseInt(scanner.nextLine());
        int oddSeats = Integer.parseInt(scanner.nextLine());
        int countSeats = 0;
        for (int i = 65; i <= lastSector.charAt(0); i++) {
            for (int j = 1; j <= rows; j++) {
                int seats = oddSeats;
                if (j % 2 == 0) {
                    seats += 2;
                }
                for (int k = 97; k < 97 + seats; k++) {
                    countSeats++;
                    System.out.printf("%s%d%s%n", Character.toString(i), j, Character.toString(k));
                }
            }
            rows++;
        }
        System.out.println(countSeats);
    }
}
