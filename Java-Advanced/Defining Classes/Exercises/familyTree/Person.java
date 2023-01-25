package definingClasses.exercises.familyTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {
    private String name;
    private String birthDate;

    private List<Person> parent = new ArrayList<>();
    private List<Person> children = new ArrayList<>();

    public Person(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;

    }
    @Override
    public String toString() {
        return name + " " + birthDate;
    }
    public void addChild(Person child) {
        children.add(child);
        child.parent.add(this);
    }

    public String getName() {
        return name;
    }
    public String getBirthDate() {
        return birthDate;
    }
    public List<Person> getParent() {
        return Collections.unmodifiableList(parent);
    }
    public List<Person> getChildren() {
        return children;
    }

}
