package exam.mid.august2020;

import java.util.Arrays;
import java.util.Scanner;

public class P02TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        int[] lift = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        boolean isThereFreeSpace = true;
        while (people > 0) {
            for (int i = 0; i < lift.length; i++) {
                int currentLift = lift[i];
                int freeSpace = 4 - currentLift;
                if (people >= freeSpace) {
                    lift[i] += freeSpace;
                    people -= freeSpace;
                } else {
                    lift[i] += people;
                    people = 0;
                }
                if (Arrays.stream(lift).allMatch(x -> x == 4)) {
                    isThereFreeSpace = false;
                    break;
                }
                if (people == 0) {
                    break;
                }
            }
            if (!isThereFreeSpace) {
                break;
            }
        }
        if (isThereFreeSpace) {
            System.out.println("The lift has empty spots!");
        } else if (people > 0){
            System.out.printf("There isn't enough space! %d people in a queue!%n", people);
        }
            System.out.println(Arrays.toString(lift)
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", ""));

    }

}
