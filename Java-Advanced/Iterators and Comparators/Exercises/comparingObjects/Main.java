package iteratorsAndComparators.exercises.comparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String name = input.split(" ")[0];
            int age = Integer.parseInt(input.split(" ")[1]);
            String town = input.split(" ")[2];
            Person person = new Person(name, age, town);
            people.add(person);
            input = scanner.nextLine();
        }
        int n = Integer.parseInt(scanner.nextLine());
        Person person = people.get(n - 1);
        int equal = 0;
        int diff = 0;
        for (Person person1 : people) {
            if (person1.compareTo(person) == 0) {
                equal++;
            } else {
                diff++;
            }
        }
        if (equal == 1) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d", equal, diff, people.size());
        }
    }
}

