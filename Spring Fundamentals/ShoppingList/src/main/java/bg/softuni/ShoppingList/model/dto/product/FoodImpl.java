package bg.softuni.ShoppingList.model.dto.product;

import java.math.BigDecimal;

public class FoodImpl implements Food {

    private String name;
    private BigDecimal price;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    public FoodImpl setName(String name) {
        this.name = name;
        return this;
    }

    public FoodImpl setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
