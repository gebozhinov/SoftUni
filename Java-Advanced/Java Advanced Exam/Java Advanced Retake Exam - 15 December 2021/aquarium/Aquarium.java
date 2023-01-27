package exam.december2021.aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private List<Fish> fishInPool;
    private String name;
    private int capacity;
    private int size;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public int getFishInPool() {
        return fishInPool.size();
    }

    public void add(Fish fish) {
        boolean flag = false;
        if (capacity > fishInPool.size()) {
            for (Fish f : fishInPool) {
                if (f.getName().equals(fish.getName())) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                fishInPool.add(fish);
            }
        }
    }

    public boolean remove(String name) {
        for (Fish fish : fishInPool) {
            if (fish.getName().equals(name)) {
                fishInPool.remove(fish);
                return true;
            }
        }
        return false;
    }

    public Fish findFish(String name) {
        return fishInPool.stream().filter(e -> e.getName().equals(name))
                .findFirst().orElse(null);
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Aquarium: %s ^ Size: %d", name, size)).append(String.format("%n"));
        fishInPool.forEach(e -> sb.append(e).append(String.format("%n")));
        return sb.toString().trim();
    }
}
