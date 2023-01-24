package setsAndMapsAdvanced.exercises;

import java.util.*;

public class P03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        TreeSet<String> chemicalSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            String[] chemicalCompounds = scanner.nextLine().split(" ");
            Collections.addAll(chemicalSet, chemicalCompounds);
        }
        chemicalSet.forEach(e -> System.out.print(e + " "));

    }
}
