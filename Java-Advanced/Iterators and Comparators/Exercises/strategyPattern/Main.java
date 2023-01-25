package iteratorsAndComparators.exercises.strategyPattern;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<Person> sortByName = new TreeSet<>(new NameComparator());
        TreeSet<Person> sortByAge = new TreeSet<>(new AgeComparator());
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String name = input.split(" ")[0];
            int age = Integer.parseInt(input.split(" ")[1]);
            Person person = new Person(name, age);
            sortByName.add(person);
            sortByAge.add(person);

        }

        for (Person person : sortByName) {
            System.out.println(person.getName() + " " + person.getAge());
        }
        for (Person person : sortByAge) {
            System.out.println(person.getName() + " " + person.getAge());
        }
    }
}
