import java.util.Scanner;

public class MovieRatings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int moviesToWatch = Integer.parseInt(scanner.nextLine());


        double totalRating = 0;
        double maxRating = Double.MIN_VALUE;
        String movieWithMaxRating = "";
        double minRating = Double.MAX_VALUE;
        String movieWithMinRating = "";
        for (int i = 0; i < moviesToWatch; i++) {
            String movieName = scanner.nextLine();
            double movieRating = Double.parseDouble(scanner.nextLine());
            totalRating += movieRating;
            if (movieRating > maxRating) {
                maxRating = movieRating;
                movieWithMaxRating = movieName;
            }
            if (movieRating < minRating) {
                minRating = movieRating;
                movieWithMinRating = movieName;
            }
        }
        double averageRating = totalRating / moviesToWatch;
        System.out.printf("%s is with highest rating: %.1f%n", movieWithMaxRating, maxRating);
        System.out.printf("%s is with lowest rating: %.1f%n", movieWithMinRating, minRating);
        System.out.printf("Average rating: %.1f", averageRating);
    }
}
