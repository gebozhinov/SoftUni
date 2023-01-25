package definingClasses.exercises.catLady;

public class Siamese extends Cat {
    private double earSize;

    public Siamese(String name, double earSize) {
        super(name);
        this.earSize = earSize;

    }

    @Override
    public String toString() {
        return String.format("definingClasses.exercises.catLady.Siamese %s %.2f", super.getName(), this.earSize);
    }
}
