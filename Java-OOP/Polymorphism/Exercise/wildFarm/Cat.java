package polymorphism.exercises.wildFarm;

public class Cat extends Feline {

    private String breed;


    public Cat(String animalName, Double animalWeight, String livingRegion,
               String breed) {
        super(animalName,"Cat", animalWeight, livingRegion);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    protected void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    protected void eat(Food food) {
        super.setFoodEaten(getFoodEaten() + food.getQuantity());

    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %s, %d]", getAnimalType(), getAnimalName(), breed, df.format(getAnimalWeight()),
                getLivingRegion(), getFoodEaten());
    }
}
