import java.util.Scanner;

public class TheSongOfTheWheels {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        String password = "";
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                for (int k = 1; k < 10; k++) {
                    for (int l = 1; l < 10; l++) {
                        if (i < j) {
                            if (k > l) {
                                if ((i * j) + (k * l) == m) {
                                    counter++;
                                    System.out.printf("%d%d%d%d ", i, j, k, l);
                                    if (counter == 4) {
                                        password = "" + i + j + k + l;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println();
        if (counter >= 4) {
            System.out.printf("Password: %s", password);
        } else {
            System.out.println("No!");
        }
    }
}

