package functionalProgramming.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class P05FilterByAge {
    public static class People {
        String name;
        int age;

        public People(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<People> peopleList = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String name = input.split(", ")[0];
            int age = Integer.parseInt(input.split(", ")[1]);
            People people = new People(name, age);
            peopleList.add(people);

        }

        String condition = scanner.nextLine();
        int formatAge = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        peopleList = filterByCondition(peopleList, condition, formatAge);

        Consumer<People> printer = getPrinter(format);

        peopleList.forEach(printer);

    }

    private static Consumer<People> getPrinter(String format) {
        switch (format) {
            case "name":
                return p -> System.out.println(p.name);
            case "age":
                return p -> System.out.println(p.age);
            case "name age":
                return p -> System.out.println(p.name + " - " + p.age);
            default:
                throw new IllegalArgumentException("Invalid input");
        }

    }


    private static List<People> filterByCondition(List<People> peopleList, String condition, int formatAge) {
        if (condition.equals("younger")) {
            return peopleList.stream()
                    .filter(p -> p.age <= formatAge)
                    .collect(Collectors.toList());
        }
        return peopleList.stream()
                .filter(p -> p.age >= formatAge)
                .collect(Collectors.toList());
    }
}
