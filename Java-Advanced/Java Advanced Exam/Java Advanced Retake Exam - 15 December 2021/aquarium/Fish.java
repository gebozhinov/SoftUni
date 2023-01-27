package exam.december2021.aquarium;

public class Fish {
    private String name;
    private String color;
    private int fins;

    public Fish(String name, String color, int fins) {
        this.name = name;
        this.color = color;
        this.fins = fins;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Fish: %s", name))
                .append(String.format("%n"))
                .append(String.format("Color: %s", color))
                .append(String.format("%n"))
                .append(String.format("Number of fins: %d", fins));
        return sb.toString();

    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getFins() {
        return fins;
    }

}
