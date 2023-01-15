package exam.mid.april2020;

import java.util.Arrays;
import java.util.Scanner;

public class P02ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] targetArr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        String input = scanner.nextLine();
        int count = 0;
        while (!input.equals("End")) {
            int index = Integer.parseInt(input);
            if (index >= 0 && index < targetArr.length) {
                int currentTarget = targetArr[index];
                targetArr[index] = -1;
                count++;
                for (int i = 0; i < targetArr.length; i++) {
                    if (targetArr[i] != -1) {
                        if (targetArr[i] > currentTarget) {
                            targetArr[i] -= currentTarget;
                        } else {
                            targetArr[i] += currentTarget;
                        }
                    }
                }
            }
            input = scanner.nextLine();
        }

        System.out.println("Shot targets: " + count + " -> " + Arrays.toString(targetArr)
                .replace("[", "")
                .replace("]", "")
                .replace(",", ""));
    }
}
