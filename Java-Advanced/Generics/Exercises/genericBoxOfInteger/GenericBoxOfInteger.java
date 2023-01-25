package generics.exercises.genericBoxOfInteger;

import java.util.ArrayList;
import java.util.List;

public class GenericBoxOfInteger<T> {
    private List<T> data;

    public GenericBoxOfInteger() {
        this.data = new ArrayList<>();
    }

    public void add(T element) {
        data.add(element);
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
