package encapsulation.exercises.pizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String pizzaData = scanner.nextLine();
        String pizzaName = pizzaData.split(" ")[1];
        int numberOfToppings = Integer.parseInt(pizzaData.split(" ")[2]);
        Pizza pizza;
        try {
            pizza = new Pizza(pizzaName, numberOfToppings);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }


        String doughData = scanner.nextLine();
        String flourType = doughData.split(" ")[1];
        String bakingTechnique = doughData.split(" ")[2];
        double doughWeight = Double.parseDouble(doughData.split(" ")[3]);

        Dough dough;
        try {
            dough = new Dough(flourType, bakingTechnique, doughWeight);
            pizza.setDough(dough);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        String command = scanner.nextLine();
        while (!"END".equals(command)) {
            String toppingType = command.split(" ")[1];
            double toppingWeight = Double.parseDouble(command.split(" ")[2]);
            Topping topping;
            try {
                topping = new Topping(toppingType, toppingWeight);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
            pizza.addTopping(topping);

            command = scanner.nextLine();
        }

        System.out.printf("%s - %.2f%n", pizza.getName(), pizza.getOverallCalories());

    }
}
