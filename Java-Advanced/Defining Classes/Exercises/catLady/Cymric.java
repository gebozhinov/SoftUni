package definingClasses.exercises.catLady;

public class Cymric extends Cat {
    private double furLength;

    public Cymric(String name, double info) {
        super(name);
        furLength = info;
    }

    @Override
    public String toString() {
        return String.format("definingClasses.exercises.catLady.Cymric %s %.2f", super.getName(), this.furLength);
    }

}
