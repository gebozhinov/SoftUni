package iteratorsAndComparators.exercises.equalityLogic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Person> treeSet = new TreeSet<>();
        Set<Person> hashSet = new HashSet<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String name = input.split(" ")[0];
            int age = Integer.parseInt(input.split(" ")[1]);
            Person person = new Person(name, age);
            treeSet.add(person);
            hashSet.add(person);

        }
        System.out.println(treeSet.size());
        System.out.println(hashSet.size());
    }
}
