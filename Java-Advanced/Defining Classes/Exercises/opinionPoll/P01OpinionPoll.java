package definingClasses.exercises.opinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class P01OpinionPoll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> personList = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String personName = input[0];
            int personAge = Integer.parseInt(input[1]);
            Person person = new Person(personName, personAge);
            personList.add(person);
        }
        personList.stream().filter(person -> person.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);
    }
}
