package bg.softuni.ShoppingList.model.dto.product;

import java.math.BigDecimal;

public class ProductInfoImpl implements ProductInfo {

    private Long id;
    private String name;
    private BigDecimal price;

    @Override
    public Long getId() {
        return id;
    }

    public ProductInfoImpl setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    public ProductInfoImpl setName(String name) {
        this.name = name;
        return this;
    }

    public ProductInfoImpl setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
