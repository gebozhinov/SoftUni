package bg.softuni.exercisejson.model.dtos.user;

import bg.softuni.exercisejson.model.dtos.product.ProductSoldDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserWithOneItemSoldDTO {
    private String firstName;
    private String lastName;
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
