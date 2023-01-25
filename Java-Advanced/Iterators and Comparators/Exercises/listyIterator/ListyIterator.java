package iteratorsAndComparators.exercises.listyIterator;

import java.util.List;

public class ListyIterator {
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
        throw new IndexOutOfBoundsException("Invalid Index");
    }

}
