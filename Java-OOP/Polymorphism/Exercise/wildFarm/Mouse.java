package polymorphism.exercises.wildFarm;

public class Mouse extends Mammal {

    public Mouse(String animalName, Double animalWeight, String livingRegion) {
        super(animalName, "Mouse", animalWeight, livingRegion);
    }

    @Override
    protected void makeSound() {
        System.out.println("SQUEEEAAAK!");

    }

    @Override
    protected void eat(Food food) {
        if (food instanceof Vegetable) {
            super.setFoodEaten(getFoodEaten() + food.getQuantity());
        } else {
            System.out.println("Mice are not eating that type of food!");
        }

    }
}
