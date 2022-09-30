import java.util.Scanner;

public class TennisEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double tennisRocketPrice = Double.parseDouble(scanner.nextLine());
        int tennisRocketAmount = Integer.parseInt(scanner.nextLine());
        int sneakers = Integer.parseInt(scanner.nextLine());

        double tennisRocketTotalPrice = tennisRocketPrice * tennisRocketAmount;
        double sneakersPrice = tennisRocketPrice / 6;
        double sneakersTotalPrice = sneakersPrice * sneakers;

        double totalPrice = (tennisRocketTotalPrice + sneakersTotalPrice) * 1.2;

        double pricePaidByDjokovic = totalPrice / 8;
        double pricePaidBySponsors = totalPrice - pricePaidByDjokovic;

        System.out.printf("Price to be paid by Djokovic %.0f%n", Math.floor(pricePaidByDjokovic));
        System.out.printf("Price to be paid by sponsors %.0f", Math.ceil(pricePaidBySponsors));

    }
}
