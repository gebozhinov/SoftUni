package definingClasses.exercises.google;

public class Pokemon {
    private String name;
    private String type;

    public Pokemon(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }
}
