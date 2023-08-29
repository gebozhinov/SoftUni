package bg.softuni.ShoppingList.model.dto;

import bg.softuni.ShoppingList.model.entity.Category;
import bg.softuni.ShoppingList.model.validation.UniqueData;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AddProductDTO {

    @UniqueData(fieldName = "name", message = "This product is already in use.")
    @Size(min = 3, max = 20, message = "Product name should be between 3 and 20 characters.")
    @NotBlank(message = "Product name should not be empty.")
    private String name;
    @Size(min = 5, message = "Description should be at least 5 characters.")
    @NotBlank(message = "Description should not be empty.")
    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @FutureOrPresent(message = "Date cannot be in the past.")
    private LocalDateTime neededBefore;
    @DecimalMin(value = "0", message = "Price should be positive number.")
    @NotNull(message = "Price should not be null.")
    private BigDecimal price;
    @Min(value = 0)
    private int category = -1;

    public String getName() {
        return name;
    }

    public AddProductDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AddProductDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDateTime getNeededBefore() {
        return neededBefore;
    }

    public AddProductDTO setNeededBefore(LocalDateTime neededBefore) {
        this.neededBefore = neededBefore;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AddProductDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public int getCategory() {
        return category;
    }

    public AddProductDTO setCategory(int category) {
        this.category = category;
        return this;
    }
}
