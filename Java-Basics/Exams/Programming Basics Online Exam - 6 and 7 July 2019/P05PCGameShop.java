import java.util.Scanner;

public class PCGameShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int gamesSold = Integer.parseInt(scanner.nextLine());

        double hearthstoneCount = 0;
        double forniteCount = 0;
        double overwatchCount = 0;
        double othersCount = 0;

        for (int i = 0; i < gamesSold; i++) {
            String gameName = scanner.nextLine();
            switch (gameName) {
                case "Hearthstone":
                    hearthstoneCount++;
                    break;
                case "Fornite":
                    forniteCount++;
                    break;
                case "Overwatch":
                    overwatchCount++;
                    break;
                default:
                    othersCount++;
                    break;
            }
        }
        double hearthstonePercent = hearthstoneCount / gamesSold * 100;
        double fornitePercent = forniteCount / gamesSold * 100;
        double overwatchPercent = overwatchCount / gamesSold * 100;
        double othersPercent = othersCount / gamesSold * 100;

        System.out.printf("Hearthstone - %.2f%%%n", hearthstonePercent);
        System.out.printf("Fornite - %.2f%%%n", fornitePercent);
        System.out.printf("Overwatch - %.2f%%%n", overwatchPercent);
        System.out.printf("Others - %.2f%%%n", othersPercent);
    }
}
