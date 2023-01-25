package definingClasses.exercises.catLady;

public class StreetExtraordinaire extends Cat {
    private double decibelsOfMeows;

    public StreetExtraordinaire(String name, double info) {
        super(name);
        decibelsOfMeows = info;
    }

    @Override
    public String toString() {
        return String.format("definingClasses.exercises.catLady.StreetExtraordinaire %s %.2f", super.getName(), this.decibelsOfMeows);
    }

}
