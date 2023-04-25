package bg.softuni.exercisejson.model.dtos.product;

import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "sold-products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductSoldCountDTO {

    @XmlAttribute
    private Integer count;
    @XmlElement(name = "product")
    private List<ProductInfoDTO> products;

    public ProductSoldCountDTO(List<ProductInfoDTO> products) {
        this.products = products;
        this.count = products.size();
    }
}
