package definingClasses.exercises.familyTree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String personInfo = scanner.nextLine();

        List<Person> people = new ArrayList<>();
        Map<String, List<String>> parentChildren = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            if (input.contains(" - ")) {
                String[] tokens = input.split(" - ");
                String parentId = tokens[0];
                String childrenId = tokens[1];
                parentChildren.putIfAbsent(parentId, new ArrayList<>());
                parentChildren.get(parentId).add(childrenId);
            } else {
                String[] tokens = input.split(" ");
                String name = tokens[0] + " " + tokens[1];
                String birthdate = tokens[2];
                people.add(new Person(name, birthdate));
            }

            input = scanner.nextLine();

        }
        parentChildren.forEach((parentId, children) -> {
            Person parent = findPerson(people, parentId);

            children.stream()
                    .map(child -> findPerson(people, child))
                    .forEach(parent::addChild);
        });

        Person forPerson = findPerson(people, personInfo);

        System.out.println(forPerson.getName() + " " + forPerson.getBirthDate());
        System.out.println("Parents:");
        forPerson.getParent().forEach(System.out::println);
        System.out.println("Children:");
        forPerson.getChildren().forEach(System.out::println);


    }

    public static Person findPerson(List<Person> people, String personId) {
        return people.stream()
                .filter(person -> person.getBirthDate().equals(personId) || person.getName().equals(personId))
                .findFirst()
                .orElseThrow();
    }

}
