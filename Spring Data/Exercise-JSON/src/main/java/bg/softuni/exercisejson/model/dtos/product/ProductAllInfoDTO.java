package bg.softuni.exercisejson.model.dtos.product;

import bg.softuni.exercisejson.model.entities.Category;
import bg.softuni.exercisejson.model.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductAllInfoDTO {
    private String name;
    private BigDecimal price;
    private User buyerId;
    private User sellerId;
    private Set<Category> categories;

    public ProductSoldCountDTO toProductSoldCountDTO() {
        return new ProductSoldCountDTO();
    }
}
