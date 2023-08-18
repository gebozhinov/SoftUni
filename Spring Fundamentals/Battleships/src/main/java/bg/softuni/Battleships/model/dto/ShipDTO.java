package bg.softuni.Battleships.model.dto;

import bg.softuni.Battleships.model.Category;
import bg.softuni.Battleships.model.User;

import java.time.LocalDate;

public class ShipDTO {

    private Long id;
    private String name;
    private Long health;
    private Long power;
    private LocalDate created;
    private Category category;
    private User user;

    public Long getId() {
        return id;
    }

    public ShipDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ShipDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Long getHealth() {
        return health;
    }

    public ShipDTO setHealth(Long health) {
        this.health = health;
        return this;
    }

    public Long getPower() {
        return power;
    }

    public ShipDTO setPower(Long power) {
        this.power = power;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public ShipDTO setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public ShipDTO setCategory(Category category) {
        this.category = category;
        return this;
    }

    public User getUser() {
        return user;
    }

    public ShipDTO setUser(User user) {
        this.user = user;
        return this;
    }
}
