package polymorphism.exercises.wildFarm;

public class Zebra extends Mammal {

    public Zebra(String animalName, Double animalWeight, String livingRegion) {
        super(animalName,"Zebra", animalWeight, livingRegion);
    }

    @Override
    protected void makeSound() {
        System.out.println("Zs");
    }

    @Override
    protected void eat(Food food) {
        if (food instanceof Vegetable) {
            super.setFoodEaten(getFoodEaten() + food.getQuantity());
        } else {
            System.out.println("Zebras are not eating that type of food!");
        }

    }
}
