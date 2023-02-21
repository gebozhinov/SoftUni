package football.entities.field;

import football.entities.player.BasePlayer;
import football.entities.player.Player;
import football.entities.supplement.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static football.common.ConstantMessages.NOT_ENOUGH_CAPACITY;
import static football.common.ExceptionMessages.FIELD_NAME_NULL_OR_EMPTY;

public abstract class BaseField implements Field {

    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Player> players;


    protected BaseField(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.supplements = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    @Override
    public int sumEnergy() {
        return supplements.stream().mapToInt(Supplement::getEnergy).sum();
    }

    @Override
    public void addPlayer(Player player) {
        if (capacity <= players.size()) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }
        players.add(player);
    }

    @Override
    public void removePlayer(Player player) {
        players.remove(player);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        supplements.add(supplement);
    }

    @Override
    public void drag() {
        players.forEach(Player::stimulation);
    }

    @Override
    public Collection<Player> getPlayers() {
        return players;
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return supplements;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getInfo() {

        String print = name + " (" + this.getClass().getSimpleName() + "):" + System.lineSeparator() +
                "Player: " + (players.size() > 0 ? playersToString(players) : "none") + System.lineSeparator() +
                "Supplement: " + supplements.size() + System.lineSeparator() +
                "Energy: " + sumEnergy() + System.lineSeparator();
        return print;
    }

    private String playersToString(Collection<Player> players) {
        StringBuilder sb = new StringBuilder();
        for (Player player : players) {
           sb.append(player.getName()).append(" ");
        }
        return sb.toString().trim();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(FIELD_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }
}
