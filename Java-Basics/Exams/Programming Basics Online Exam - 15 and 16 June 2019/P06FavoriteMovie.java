import java.util.Scanner;

public class FavoriteMovie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String movieName = scanner.nextLine();
        int mostPoints = 0;
        int moviesCount = 1;
        String favoriteMovie = "";
        while (!movieName.equals("STOP")) {
            int points = 0;
            for (int i = 0; i < movieName.length(); i++) {
                int ascii = movieName.charAt(i);
                points += ascii;
                if (ascii >= 97 && ascii <= 122) {
                    points -= movieName.length() * 2;
                } else if (ascii >= 65 && ascii <= 90) {
                    points -= movieName.length();
                }
                if (points >= mostPoints) {
                    mostPoints = points;
                    favoriteMovie = movieName;
                }
            }
            if (moviesCount == 7) {
                System.out.println("The limit is reached.");
                break;
            }
            movieName = scanner.nextLine();
            moviesCount++;
        }
        System.out.printf("The best movie for you is %s with %d ASCII sum.", favoriteMovie, mostPoints);
    }
}
