package encapsulation.exercises.shoppingSpree;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] peopleData = scanner.nextLine().split(";");

        Map<String, Person> people = new LinkedHashMap<>();
        for (String currentPerson : peopleData) {
            String name = currentPerson.split("=")[0];
            double money = Double.parseDouble(currentPerson.split("=")[1]);
            try {
                Person person = new Person(name, money);
                people.putIfAbsent(name, person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        String[] productData = scanner.nextLine().split(";");

        Map<String, Product> products = new LinkedHashMap<>();
        for (String currentProduct : productData) {
            String name = currentProduct.split("=")[0];
            double cost = Double.parseDouble(currentProduct.split("=")[1]);
            try {
                Product product = new Product(name, cost);
                products.putIfAbsent(name, product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            String name = input.split(" ")[0];
            String product = input.split(" ")[1];

            try {
                people.get(name).buyProduct(products.get(product));
                System.out.printf("%s bought %s%n", name , product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            input = scanner.nextLine();
        }

        people.values().forEach(System.out::println);
    }
}
