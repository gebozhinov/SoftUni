package bg.softuni.exercisejson.model.dtos.user;

import bg.softuni.exercisejson.model.dtos.product.ProductSoldCountDTO;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserAndProductDTO {

    @XmlAttribute(name = "first-name")
    private String firstName;
    @XmlAttribute(name = "last-name")
    private String lastName;
    @XmlAttribute
    private int age;
    @XmlElement(name = "sold-products")
    private ProductSoldCountDTO soldProducts;

}
