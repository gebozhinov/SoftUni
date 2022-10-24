import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05DrumSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double budget = Double.parseDouble(scanner.nextLine());
        List<Integer> initialDrumSet = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> drumSet = new ArrayList<>();
        drumSet.addAll(initialDrumSet);

        String input = scanner.nextLine();
        while (!input.equals("Hit it again, Gabsy!")) {
            int hitPower = Integer.parseInt(input);
            for (int i = 0; i < drumSet.size(); i++) {
                drumSet.set(i, drumSet.get(i) - hitPower);
                if (drumSet.get(i) <= 0) {
                    if (initialDrumSet.get(i) * 3 <= budget) {
                        drumSet.set(i, initialDrumSet.get(i));
                        budget -= initialDrumSet.get(i) * 3;
                    } else {
                        drumSet.remove(i);
                        initialDrumSet.remove(i);
                        i--;
                    }
                }
            }

            input = scanner.nextLine();
        }
        System.out.print(Arrays.toString(drumSet.toArray())
                .replace("[", "")
                .replace("]", "")
                .replace(",", ""));
        System.out.println();
        System.out.printf("Gabsy has %.2flv.", budget);

    }
}
