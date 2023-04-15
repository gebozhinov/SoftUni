package bg.softuni.exercisejson.model.dtos.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class ProductDTO {

    private String name;
    private BigDecimal price;
    private String sellerFullName;
}
