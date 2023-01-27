package exam.august2022.sanctuary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Habitat {
    private List<Elephant> data;
    private int capacity;

    public Habitat(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Elephant elephant) {
        if (capacity > data.size()) {
            data.add(elephant);
        }
    }

    public boolean remove(String name) {
        for (Elephant elephant : data) {
            String current = elephant.getName();
            if (current.equals(name)) {
                data.remove(elephant);
                return true;
            }
        }
        return false;
    }

    public Elephant getElephant(String retiredFrom) {
        return data.stream().filter(e -> e.getRetiredFrom().equals(retiredFrom))
                .findFirst().orElse(null);
    }

    public Elephant getOldestElephant() {
        return data.stream().max(Comparator.comparing(Elephant::getAge)).get();
    }

    public int getAllElephants() {
        return data.size();
    }

    public String getReport() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Saved elephants in the park:%n"));
        data.forEach(e -> sb.append(e.getName()).append(" came from: ").append(e.getRetiredFrom()).append(String.format("%n")));
        return sb.toString();
    }
}
