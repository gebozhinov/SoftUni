package definingClasses.exercises.rawData;

public class Cargo {
    private int wight;
    private String type;

    public Cargo(int wight, String type) {
        this.wight = wight;
        this.type = type;
    }

    public int getWight() {
        return this.wight;
    }

    public String getType() {
        return this.type;
    }
}
