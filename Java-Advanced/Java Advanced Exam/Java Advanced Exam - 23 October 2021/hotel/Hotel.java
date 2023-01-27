package exam.october2021.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Person> roster;
    private String name;
    private int capacity;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person) {
        if (capacity > roster.size()) {
            roster.add(person);
        }
    }

    public boolean remove(String name) {
        for (Person person : roster) {
            if (person.getName().equals(name)) {
                roster.remove(person);
                return true;
            }
        }
        return false;
    }

    public Person getPerson(String name, String hometown) {
        return roster.stream().filter(e -> e.getName().equals(name))
                .filter(e -> e.getHometown().equals(hometown))
                .findFirst().orElse(null);
    }

    public int getCount() {
        return roster.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The people in the exam.october2021.hotel %s are:", name)).append(String.format("%n"));
        roster.forEach(e -> sb.append(e).append(String.format("%n")));
        return sb.toString().trim();
    }
}
