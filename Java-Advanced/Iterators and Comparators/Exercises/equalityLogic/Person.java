package iteratorsAndComparators.exercises.equalityLogic;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (this.getClass() != other.getClass()) {
            return false;
        }
        Person person = (Person) other;
        return person.name.equals(name) &&
                person.age == age;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public int compareTo(Person other) {
        int result = this.getName().compareTo(other.getName());
        if (result == 0) {
            result = Integer.compare(this.getAge(), other.getAge());
        }
        return result;
    }
}
