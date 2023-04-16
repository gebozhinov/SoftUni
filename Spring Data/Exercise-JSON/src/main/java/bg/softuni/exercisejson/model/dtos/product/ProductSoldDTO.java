package bg.softuni.exercisejson.model.dtos.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductSoldDTO {
    private String name;
    private BigDecimal price;
    private String buyerIdFirstName;
    private String buyerIdLastName;
}
