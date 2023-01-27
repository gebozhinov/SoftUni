package exam.april2022.easterBasket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Basket {
    private List<Egg> data;
    private String material;
    private int capacity;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addEgg(Egg egg) {
        if (capacity > data.size()) {
            data.add(egg);
        }
    }

    public boolean removeEgg(String color) {
        for (Egg egg : data) {
            if (egg.getColor().equals(color)) {
                data.remove(egg);
                return true;
            }
        }
        return false;
    }

    public Egg getStrongestEgg() {
        return data.stream().max(Comparator.comparing(Egg::getStrength)).orElse(null);
    }

    public Egg getEgg(String color) {
        return data.stream().filter(e -> e.getColor().equals(color)).findFirst().orElse(null);
    }
    public int getCount() {
        return data.size();
    }
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s basket contains:%n", material));
        data.forEach(e -> sb.append(e.toString()).append(String.format("%n")));
        return sb.toString().trim();
    }
}
