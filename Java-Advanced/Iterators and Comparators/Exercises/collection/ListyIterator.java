package iteratorsAndComparators.exercises.collection;

import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {
    private List<String> data;
    private int index;

    public ListyIterator(String... data) {
        this.data = List.of(data);
        this.index = 0;
    }

    public boolean move() {
        if (index < data.size() - 1) {
            index++;
            return true;
        } else {
            return false;
        }
    }

    public boolean hasNext() {
        return index < data.size() - 1;
    }

    public String print() {
        if (index >= 0 && index < data.size()) {
            return data.get(index);
        }
        throw new IndexOutOfBoundsException("Invalid index");
    }



    @Override
    public Iterator<String> iterator() {
        return new Iterator<>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < data.size();
            }

            @Override
            public String next() {
                return data.get(index++);
            }
        };
    }
}
