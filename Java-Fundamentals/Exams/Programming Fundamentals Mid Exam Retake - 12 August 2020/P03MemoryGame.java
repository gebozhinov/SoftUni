package exam.mid.august2020;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> elementList = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());
        String input = scanner.nextLine();
        int moves = 0;
        while (!input.equals("end")) {
            int n1 = Integer.parseInt(input.split(" ")[0]);
            int n2 = Integer.parseInt(input.split(" ")[1]);
            moves++;
            if (n1 == n2 || Math.min(n1, n2) < 0 || Math.max(n1, n2) >= elementList.size()) {
                elementList.add(elementList.size() / 2, "-" + moves + "a");
                elementList.add(elementList.size() / 2, "-" + moves + "a");
                System.out.println("Invalid input! Adding additional elements to the board");
                input = scanner.nextLine();
                continue;
            }
            String matchElement1 = elementList.get(n1);
            String matchElement2 = elementList.get(n2);
            if (matchElement1.equals(matchElement2)) {
                elementList.remove(matchElement1);
                elementList.remove(matchElement2);
                System.out.printf("Congrats! You have found matching elements - %s!%n", matchElement1);
            } else {
                System.out.println("Try again!");
            }
            if (elementList.isEmpty()) {
                System.out.printf("You have won in %d turns!", moves);
                break;
            }

            input = scanner.nextLine();
        }
        if (input.equals("end")) {
            System.out.println("Sorry you lose :(");
            System.out.println(String.join(" ", elementList));
        }

    }
}
