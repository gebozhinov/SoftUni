package iteratorsAndComparators.exercises.stackIterator;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class CustomStack implements Iterable<Integer> {
    private Stack<Integer> data;

    public CustomStack(Integer... data) {
        this.data = new Stack<>();
        this.data.addAll(List.of(data));
    }

    public void push(int number) {
        data.push(number);
    }

    public void pop() {
        data.pop();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            private int index = data.size() - 1;

            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public Integer next() {
                return data.get(index--);
            }
        };
    }
}
