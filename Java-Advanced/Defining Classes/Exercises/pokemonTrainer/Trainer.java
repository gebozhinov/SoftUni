package definingClasses.exercises.pokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int badges;
    private List<Pokemon> pokemonList;

    public Trainer(String name, Pokemon pokemon) {
        this.name = name;
        this.pokemonList = new ArrayList<>();
        this.pokemonList.add(pokemon);
        this.badges = 0;
    }
    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.badges, this.pokemonList.size());
    }

    public String getName() {
        return this.name;
    }

    public int getBadges() {
        return this.badges;
    }

    public List<Pokemon> getPokemonList() {
        return this.pokemonList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }

    public void updateBadges() {
        this.badges += 1;
    }

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemonList.add(pokemon);
    }

    public void removePokemon(Pokemon pokemon) {
        this.pokemonList.remove(pokemon);
    }


}
