package iteratorsAndComparators.exercises.froggy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer>{
    private List<Integer> data;

    public Lake(List<Integer> data) {
        this.data = new ArrayList<>();
        this.data.addAll(data);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }
    class Frog implements Iterator<Integer> {
            private int index = 0;
            boolean firstRound = false;
        @Override
        public boolean hasNext() {
            return index < data.size();
        }

        @Override
        public Integer next() {
            int current = index;
            index += 2;
            if (index >= data.size() && !firstRound) {
                index = 1;
                firstRound = true;
            }
            return data.get(current);
        }
    }

}
