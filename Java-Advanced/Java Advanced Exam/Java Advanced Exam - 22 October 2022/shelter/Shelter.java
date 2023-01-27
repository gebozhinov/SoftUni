package exam.october2022.shelter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shelter {
    private List<Animal> data;
    private int capacity;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public List<Animal> data() {
        return this.data;
    }

    public void add(Animal animal) {
        if (capacity > data.size()) {
            data.add(animal);
        }
    }

    public boolean remove(String name) {
        for (Animal animal : data) {
            if (animal.getName().equals(name)) {
                data.remove(animal);
                return true;
            }
        }
        return false;
    }

    public Animal getAnimal(String name, String caretaker) {
        return data.stream().filter(e -> e.getName().equals(name))
                .filter(e -> e.getCaretaker().equals(caretaker))
                .findFirst().orElse(null);
    }

    public Animal getOldestAnimal() {
      return data.stream().max(Comparator.comparing(Animal::getAge)).get();
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The exam.october2022.shelter has the following animals:%n"));
        data.forEach(e -> sb.append(e.getName()).append(" ").append(e.getCaretaker()).append(String.format("%n")));
        return sb.toString();
    }
}
