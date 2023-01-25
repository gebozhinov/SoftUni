package iteratorsAndComparators.exercises.strategyPattern;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person first, Person second) {
        int result = Integer.compare(first.getName().length(), second.getName().length());
        if (result == 0) {
            result = Character.compare(first.getName().toLowerCase().charAt(0), second.getName().toLowerCase().charAt(0));
        }
        return result;
    }
}
