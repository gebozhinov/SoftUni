package generics.exercises.genericCountMethodString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> data;

    public Box() {
        this.data = new ArrayList<>();
    }

    public void add(T element) {
        data.add(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        Collections.swap(data, firstIndex, secondIndex);
    }

    public long compare(T element) {
        return data.stream().filter(e -> e.compareTo(element) > 0).count();
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : data) {
            sb.append(String.format("%s: %s%n", element.getClass().getName(), element));
        }
        return sb.toString();
    }
}
