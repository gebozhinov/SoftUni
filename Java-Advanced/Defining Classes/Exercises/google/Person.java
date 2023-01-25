package definingClasses.exercises.google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Parent> parents;
    private List<Children> children;
    private List<Pokemon> pokemon;

    public Person(String name) {
        this.name = name;
        this.pokemon = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.company = null;
        this.car = null;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void addParents(Parent parent) {
        this.parents.add(parent);
    }

    public void addChildren(Children children) {
        this.children.add(children);
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemon.add(pokemon);
    }

    public String getName() {
        return this.name;
    }

    public Company getCompany() {
        return this.company;
    }

    public Car getCar() {
        return this.car;
    }

    public List<Parent> getParents() {
        return this.parents;
    }

    public List<Children> getChildren() {
        return this.children;
    }

    public List<Pokemon> getPokemon() {
        return this.pokemon;
    }
}
