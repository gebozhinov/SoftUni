package exam.february2022.parrots;

public class Parrot {
    private String name;
    private String species;
    private boolean available = true;

    public Parrot(String name, String species) {
        this.name = name;
        this.species = species;
    }
    @Override
    public String toString() {
        return String.format("Parrot (%s): %s", species, name);
    }

    public String getName() {
        return name;
    }
    public String getSpecies() {
        return species;
    }
    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
}
