import java.util.Scanner;

public class HighJump {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int wantedHeight = Integer.parseInt(scanner.nextLine());

        int trainingHeight = wantedHeight - 30;
        int tries = 0;
        int jumpsCount = 0;
        boolean isSuccessful = true;
        while (true) {
            int jump = Integer.parseInt(scanner.nextLine());
            jumpsCount++;
            if (jump > wantedHeight && trainingHeight >= wantedHeight) {
                break;
            }
            if (jump > trainingHeight) {
                trainingHeight += 5;
                tries = 0;
            } else {
                tries++;
            }
            if (tries == 3) {
                isSuccessful = false;
                break;
            }
        }
        if (isSuccessful) {
            System.out.printf("Tihomir succeeded, he jumped over %dcm after %d jumps.", trainingHeight, jumpsCount);
        } else {
            System.out.printf("Tihomir failed at %dcm after %d jumps.", trainingHeight, jumpsCount);
        }
    }
}
