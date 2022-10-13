import java.util.Arrays;
import java.util.Scanner;

public class P06LadyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] sizeOfField = new int[Integer.parseInt(scanner.nextLine())];
        int[] initialIndexesOfAllBugs = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        for (int bug : initialIndexesOfAllBugs) {
            if ( bug >= 0 && bug < sizeOfField.length) {
                sizeOfField[bug] = 1;
            }
        }

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] action = input.split(" ");
            int ladybugIndex = Integer.parseInt(action[0]);
            int flyLength = Integer.parseInt(action[2]);

            if (ladybugIndex < 0 || ladybugIndex >= sizeOfField.length || sizeOfField[ladybugIndex] == 0) {
                input = scanner.nextLine();
                continue;
            }

            if ((action[1].equals("right") && flyLength > 0) || flyLength < 0) {
                sizeOfField[ladybugIndex] = 0;
                for (int i = ladybugIndex + Math.abs(flyLength); i < sizeOfField.length; i += Math.abs(flyLength)) {
                    if (sizeOfField[i] == 0) {
                        sizeOfField[i] = 1;
                        break;
                    }
                }
            } else {
                sizeOfField[ladybugIndex] = 0;
                for (int i = ladybugIndex - flyLength; i >= 0; i -= flyLength) {
                    if (sizeOfField[i] == 0) {
                        sizeOfField[i] = 1;
                        break;
                    }
                }
                input = scanner.nextLine();
            }
        }
      System.out.print(Arrays.toString(sizeOfField).replace("[", "")
                .replace("]", "")
                .replace(",", ""));
    }
}
