package generics.lab;

import java.util.List;

public class ListUtils<T> {


    public static <T extends Comparable<T>> T getMin(List<T> list) {
        return list.stream()
                .min(T::compareTo)
                .orElseThrow(IllegalArgumentException::new);
    }
    public static <T extends Comparable<T>> T getMax(List<T> list) {
        return list.stream()
                .max(T::compareTo)
                .orElseThrow(IllegalArgumentException::new);
    }
}
