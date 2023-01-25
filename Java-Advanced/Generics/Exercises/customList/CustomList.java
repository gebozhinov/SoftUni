package generics.exercises.customList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> data;

    public CustomList() {
        this.data = new ArrayList<>();
    }

    public void add(T element) {
        data.add(element);
    }

    public T remove(int index) {
        return data.remove(index);
    }

    public boolean contains(T element) {
        return data.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        Collections.swap(data, firstIndex, secondIndex);
    }

    public int countGreaterThan(T element) {
        return (int) data.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    public T getMax() {
        return data.stream().max(Comparator.naturalOrder()).get();
    }

    public T getMin() {
        return data.stream().min(Comparator.naturalOrder()).get();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : data) {
            sb.append(String.format("%s%n", element));
        }
        return sb.toString();
    }
}
