package bg.softuni.LinkedOut.model.dto;

import bg.softuni.LinkedOut.model.validation.UniqueCompanyName;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;


public class AddCompanyDTO {

    @NotBlank(message = "Enter name.")
    @Size(min = 2, max = 10, message = "Name must be between 2 and 10 characters!")
    @UniqueCompanyName
    private String name;
    @NotBlank(message = "Enter town name.")
    @Size(min = 2, max = 10, message = "Town name must be between 2 and 10 characters!")
    private String town;
    @NotBlank(message = "Enter description")
    @Size(min = 10, message = "Description must be at least 10 characters!")
    private String description;
    @NotNull(message = "Enter budget.")
    @DecimalMin(value = "0", message = "Budget must be positive number!")
    private BigDecimal budget;

    public String getName() {
        return name;
    }

    public AddCompanyDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getTown() {
        return town;
    }

    public AddCompanyDTO setTown(String town) {
        this.town = town;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AddCompanyDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public AddCompanyDTO setBudget(BigDecimal budget) {
        this.budget = budget;
        return this;
    }
}
