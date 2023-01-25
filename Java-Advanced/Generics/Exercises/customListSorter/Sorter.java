package generics.exercises.customListSorter;

public class Sorter {

    public static <T extends Comparable<T>> void sort(CustomList<T> list) {
        for (int i = 0; i < list.size(); i++) {
            T firstElement = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                T secondElement = list.get(j);
                if (firstElement.compareTo(secondElement) > 0) {
                    list.swap(i, j);
                }
            }
        }
    }
}
