package bg.softuni.Battleships.model.dto;

import bg.softuni.Battleships.model.validation.UniqueData;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class AddShipDTO {

    @Size(min = 2, max = 10, message = "Name must be between 2 and 10 characters.")
    @UniqueData(fieldName = "name", message = "Name is already in use.")
    private String name;
    @Positive
    @NotNull
    private Long power;
    @Positive
    @NotNull
    private Long health;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    @NotNull
    private LocalDate created;
    @Min(0)
    private int category = -1;


    public String getName() {
        return name;
    }

    public AddShipDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Long getPower() {
        return power;
    }

    public AddShipDTO setPower(Long power) {
        this.power = power;
        return this;
    }

    public Long getHealth() {
        return health;
    }

    public AddShipDTO setHealth(Long health) {
        this.health = health;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public AddShipDTO setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public int getCategory() {
        return category;
    }

    public AddShipDTO setCategory(int category) {
        this.category = category;
        return this;
    }
}
