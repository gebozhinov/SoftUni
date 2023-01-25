package definingClasses.exercises.google;

public class Parent {
    private String name;
    private String birthdate;

    public Parent(String name, String birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    public String getName() {
        return this.name;
    }

    public String getBirthdate() {
        return this.birthdate;
    }
}
