package definingClasses.exercises.google;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        LinkedHashMap<String, Person> people = new LinkedHashMap<>();
        String personInfo = scanner.nextLine();
        while (!personInfo.equals("End")) {
            String personName = personInfo.split(" ")[0];
            String token = personInfo.split(" ")[1];
            String tokenName = personInfo.split(" ")[2];
            String tokenType = personInfo.split(" ")[3];

            Person person = new Person(personName);
            switch (token) {
                case "company":
                    double salary = Double.parseDouble(personInfo.split(" ")[4]);
                    Company company = new Company(tokenName, tokenType, salary);
                    if (people.containsKey(personName)) {
                        people.get(personName).setCompany(company);
                    } else {
                        person.setCompany(company);
                        people.put(personName, person);
                    }
                    break;
                case "pokemon":
                    Pokemon pokemon = new Pokemon(tokenName, tokenType);
                    if (people.containsKey(personName)) {
                        people.get(personName).addPokemon(pokemon);
                    } else {
                        person.addPokemon(pokemon);
                        people.put(personName, person);
                    }
                    break;
                case "parents":
                    Parent parent = new Parent(tokenName, tokenType);
                    if (people.containsKey(personName)) {
                        people.get(personName).addParents(parent);
                    } else {
                        person.addParents(parent);
                        people.put(personName, person);
                    }
                    break;
                case "children":
                    Children children = new Children(tokenName, tokenType);
                    if (people.containsKey(personName)) {
                        people.get(personName).addChildren(children);
                    } else {
                        person.addChildren(children);
                        people.put(personName, person);
                    }
                    break;
                case "car":
                    int speed = Integer.parseInt(tokenType);
                    Car car = new Car(tokenName, speed);
                    if (people.containsKey(personName)) {
                        people.get(personName).setCar(car);
                    } else {
                        person.setCar(car);
                        people.put(personName, person);
                    }
                    break;
            }

            personInfo = scanner.nextLine();
        }

        List<Person> finalList = new ArrayList<>();
        for (var entry : people.entrySet()) {
            finalList.add(entry.getValue());
        }

        String name = scanner.nextLine();
        System.out.println(name);
        finalList.stream().filter(person -> person.getName().equals(name))
                .forEach(element -> {
                    System.out.println("definingClasses.exercises.google.Company:");
                    if (element.getCompany() != null) {
                        System.out.printf("%s %s %.2f%n", element.getCompany().getName()
                                , element.getCompany().getDepartment()
                                , element.getCompany().getSalary());
                    }
                    System.out.println("definingClasses.exercises.google.Car:");
                    if (element.getCar() != null) {
                        System.out.printf("%s %d%n", element.getCar().getModel(), element.getCar().getSpeed());
                    }
                    System.out.println("definingClasses.exercises.google.Pokemon:");
                    if (element.getPokemon() != null) {
                        element.getPokemon().forEach(pokemon -> System.out.printf("%s %s%n", pokemon.getName(), pokemon.getType()));
                    }
                    System.out.println("Parents:");
                    if (element.getParents() != null) {
                        element.getParents().forEach(parent -> System.out.printf("%s %s%n", parent.getName(), parent.getBirthdate()));
                    }
                    System.out.println("definingClasses.exercises.google.Children:");
                    if (element.getChildren() != null) {
                        element.getChildren().forEach(children -> System.out.printf("%s %s%n", children.getName(), children.getBirthdate()));
                    }
                });

    }
}
