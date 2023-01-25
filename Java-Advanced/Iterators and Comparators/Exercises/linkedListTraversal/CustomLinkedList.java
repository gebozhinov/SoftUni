package iteratorsAndComparators.exercises.linkedListTraversal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomLinkedList implements Iterable<Integer> {
    private List<Integer> numbers;

    public CustomLinkedList() {
        this.numbers = new ArrayList<>();
    }

    public void add(int number) {
        this.numbers.add(numbers.size(), number);
    }
    public boolean remove(int number) {
        for (Integer integer : numbers) {
            if (integer == number) {
                numbers.remove(integer);
                return true;
            }
        }
        return false;
    }
    public int getSize() {
        return numbers.size();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < numbers.size();
            }

            @Override
            public Integer next() {
                return numbers.get(index++);
            }
        };
    }
}
