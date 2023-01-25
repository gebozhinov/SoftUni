package definingClasses.exercises.rawData;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tire> tire;

    public Car(String model, Engine engine, Cargo cargo, List<Tire> tire) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tire = new ArrayList<>();
        this.tire.addAll(tire);
    }
    @Override
    public String toString() {
        return String.format("%s", this.model);
    }

    public boolean isTyrePressureEnough() {
        for (Tire value : tire) {
            if (value.getPressure() < 1) {
                return true;
            }
        }
        return false;
    }
    public boolean isEnginePowerEnough() {
        return engine.getPower() > 250;

    }

    public String getModel() {
        return this.model;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public Cargo getCargo() {
        return this.cargo;
    }

    public List<Tire> getTire() {
        return this.tire;
    }
}
