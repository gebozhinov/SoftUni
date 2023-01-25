package generics.exercises.genericBox;

import java.util.ArrayList;
import java.util.List;

public class GenericBox {
    private List<String> data;

    public GenericBox() {
        data = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String element : data) {
            sb.append(String.format("%s: %s%n", element.getClass().getName(), element));
        }
        return sb.toString();
    }

    public void add(String element) {
        data.add(element);
    }

}
