package definingClasses.exercises.speedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCost;
    private int distance;

    public Car(String model, double fuelAmount, double fuelCost) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCost = fuelCost;
        this.distance = 0;
    }
    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distance);
    }
    public boolean isFuelEnough(double kilometers) {
        return kilometers * fuelCost <= fuelAmount;
    }
    public void moveCar(double kilometers) {
        this.fuelAmount -= kilometers * fuelCost;
        this.distance += kilometers;
    }
    public String getModel() {
        return this.model;
    }

}
