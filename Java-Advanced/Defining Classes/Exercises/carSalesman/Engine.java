package definingClasses.exercises.carSalesman;

public class Engine {
    private String model;
    private int power;
    private String displacement;
    private String efficiency;

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
        this.displacement = "n/a";
        this.efficiency = "n/a";
    }

    @Override
    public String toString() {
        return String.format("%s:%n" +
                "Power: %d%n" +
                "Displacement: %s%n" +
                "Efficiency: %s", this.model, this.power, this.displacement, this.efficiency);
    }


    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    public String getModel() {
        return this.model;
    }
}
