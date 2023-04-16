package bg.softuni.exercisejson.model.dtos.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ProductSoldCountDTO {

    private Integer count;
    private List<ProductInfoDTO> products;

    public ProductSoldCountDTO(List<ProductInfoDTO> products) {
        this.products = products;
        this.count = products.size();
    }
}
