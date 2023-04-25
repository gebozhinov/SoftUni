package bg.softuni.exercisejson.model.dtos.category;

import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "category")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoriesByProductCountDTO {

    @XmlAttribute
    private String name;
    @XmlElement(name = "product-count")
    private Long productsCount;
    @XmlElement(name = "average-price")
    private Double averagePrice;
    @XmlElement(name = "total-revenue")
    private BigDecimal totalRevenue;
}
