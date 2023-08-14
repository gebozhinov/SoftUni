package bg.softuni.Mobilelele.model.dto;

import bg.softuni.Mobilelele.model.enums.Engine;
import bg.softuni.Mobilelele.model.enums.Transmission;
import jakarta.validation.constraints.*;


import java.math.BigDecimal;

public class AddOfferDTO {


    @NotNull
    @Min(1)
    private Long modelId;

    @NotNull(message = "Price is required.")
    @DecimalMin(value = "0", message = "Price must be positive.")
    private BigDecimal price;

    @NotNull
    private Engine engine;

    @NotNull
    private Transmission transmission;

    @NotNull
    @Min(1930)
    private Integer year;

    @NotNull
    @Positive
    private Integer mileage;

    @NotBlank
    private String description;
    @NotBlank
    private String imageURL;

    public Long getModelId() {
        return modelId;
    }

    public AddOfferDTO setModelId(Long modelId) {
        this.modelId = modelId;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AddOfferDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Engine getEngine() {
        return engine;
    }

    public AddOfferDTO setEngine(Engine engine) {
        this.engine = engine;
        return this;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public AddOfferDTO setTransmission(Transmission transmission) {
        this.transmission = transmission;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public AddOfferDTO setYear(Integer year) {
        this.year = year;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public AddOfferDTO setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AddOfferDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageURL() {
        return imageURL;
    }

    public AddOfferDTO setImageURL(String imageURL) {
        this.imageURL = imageURL;
        return this;
    }
}
