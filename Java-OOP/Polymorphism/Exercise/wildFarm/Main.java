package polymorphism.exercises.wildFarm;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();
        List<Food> foods = new ArrayList<>();

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] animalInfo = input.split("\\s+");
            String type = animalInfo[0];
            String name = animalInfo[1];
            double weight = Double.parseDouble(animalInfo[2]);
            String livingRegion = animalInfo[3];

            switch (type) {
                case "Mouse":
                    Mouse mouse = new Mouse(name, weight, livingRegion);
                    animals.add(mouse);
                    break;
                case "Zebra":
                    Zebra zebra = new Zebra(name, weight, livingRegion);
                    animals.add(zebra);
                    break;
                case "Cat":
                    String breed = animalInfo[4];
                    Cat cat = new Cat(name, weight, livingRegion, breed);
                    animals.add(cat);
                    break;
                case "Tiger":
                    Tiger tiger = new Tiger(name, weight, livingRegion);
                    animals.add(tiger);
                    break;
            }

            String[] foodInfo = scanner.nextLine().split("\\s+");
            String foodType = foodInfo[0];
            int quantity = Integer.parseInt(foodInfo[1]);

            switch (foodType) {
                case "Vegetable":
                    Vegetable vegetable = new Vegetable(quantity);
                    foods.add(vegetable);
                    break;
                case "Meat":
                    Meat meat = new Meat(quantity);
                    foods.add(meat);
                    break;
            }


            input = scanner.nextLine();
        }

        for (int i = 0; i < animals.size(); i++) {
            Animal animal = animals.get(i);
            Food food = foods.get(i);

            animal.makeSound();
            animal.eat(food);
        }

        for (Animal animal : animals) {
            System.out.println(animal);
        }

    }
}
