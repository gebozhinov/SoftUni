package generics.lab;

import java.util.ArrayDeque;

public class Jar<T> {
    private ArrayDeque<T> elements;

    public Jar() {
        this.elements = new ArrayDeque<>();
    }
    public void add(T element) {
        this.elements.add(element);
    }

    public T remove() {
        return elements.pop();
    }
}
