package definingClasses.exercises.catLady;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Cat> cats = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String catBreed = input.split(" ")[0];
            String catName = input.split(" ")[1];
            double information = Double.parseDouble(input.split(" ")[2]);
            Cat cat = null;
            switch (catBreed) {
                case "definingClasses.exercises.catLady.Siamese":
                    cat = new Siamese(catName, information);
                    break;
                case "definingClasses.exercises.catLady.Cymric":
                    cat = new Cymric(catName, information);
                    break;
                case "definingClasses.exercises.catLady.StreetExtraordinaire":
                    cat = new StreetExtraordinaire(catName, information);
                    break;
            }

            cats.add(cat);

            input = scanner.nextLine();
        }
        String catName = scanner.nextLine();
        cats.stream().filter(cat -> cat.getName().equals(catName))
                .forEach(System.out::println);
    }
}
