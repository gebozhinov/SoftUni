package polymorphism.exercises.wildFarm;

public class Tiger extends Feline {

    private String livingRegion;

    public Tiger(String animalName, Double animalWeight, String livingRegion) {
        super(animalName,"Tiger",  animalWeight, livingRegion);
        this.livingRegion = livingRegion;
    }

    @Override
    public String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }

    @Override
    protected void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    protected void eat(Food food) {
        if (food instanceof Meat) {
            super.setFoodEaten(getFoodEaten() + food.getQuantity());
        } else {
            System.out.println("Tigers are not eating that type of food!");
        }

    }
}
