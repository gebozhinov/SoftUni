package bg.softuni.exercisejson.model.dtos.user;

import bg.softuni.exercisejson.model.dtos.product.ProductSoldDTO;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserWithOneItemSoldDTO {

    @XmlAttribute(name = "first-name")
    private String firstName;
    @XmlAttribute(name = "last-name")
    private String lastName;
    @XmlElement(name = "sold-products")
    private List<ProductSoldDTO> productsSold;

    public UserWithOneItemSoldDTO() {
        this.productsSold = new ArrayList<>();
    }

    public UserWithOneItemSoldDTO(String firstName, String lastName) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
