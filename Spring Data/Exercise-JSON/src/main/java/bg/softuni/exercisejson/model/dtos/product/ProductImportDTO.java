package bg.softuni.exercisejson.model.dtos.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class ProductImportDTO {

    private String name;
    private BigDecimal price;
}
