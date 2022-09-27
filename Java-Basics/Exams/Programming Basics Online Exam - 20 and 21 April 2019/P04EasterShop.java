import java.util.Scanner;

public class EasterShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startingEggs = Integer.parseInt(scanner.nextLine());

        int finalEggs = startingEggs;
        int eggsSold = 0;
        boolean flag = false;
        String command = scanner.nextLine();
        while (!command.equals("Close")) {
            int eggs = Integer.parseInt(scanner.nextLine());
            switch (command) {
                case "Buy":
                    if (finalEggs - eggs < 0) {
                        flag = true;
                        break;
                    }
                    finalEggs -= eggs;
                    eggsSold += eggs;
                    break;
                case "Fill":
                    finalEggs += eggs;
                    break;
            }
            if (flag) {
                break;
            }
            command = scanner.nextLine();
        }
        if (command.equals("Close")) {
            System.out.println("Store is closed!");
            System.out.printf("%d eggs sold.", eggsSold);
        } else {
            System.out.println("Not enough eggs in store!");
            System.out.printf("You can buy only %d.", finalEggs);
        }

    }
}
