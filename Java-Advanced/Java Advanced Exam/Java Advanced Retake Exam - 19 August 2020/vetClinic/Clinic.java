package exam.august2020.vetClinic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Clinic {
    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (capacity > data.size()) {
            data.add(pet);
        }
    }

    public boolean remove(String name) {
        for (Pet pet : data) {
            if (pet.getName().equals(name)) {
                data.remove(pet);
                return true;
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner) {
        return data.stream().filter(e -> e.getName().equals(name))
                .filter(e -> e.getOwner().equals(owner))
                .findFirst().orElse(null);
    }

    public Pet getOldestPet() {
        return data.stream().max(Comparator.comparing(Pet::getAge)).get();
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The clinic has the following patients:").append(String.format("%n"));
        data.forEach(e -> sb.append(e.getName())
                .append(" ")
                .append(e.getOwner())
                .append(String.format("%n")));
        return sb.toString().trim();
    }
}
