package bg.softuni.exercisejson.model.dtos.user;

import bg.softuni.exercisejson.model.dtos.product.ProductSoldCountDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserAndProductDTO {

    private String firstName;
    private String lastName;
    private int age;
    private ProductSoldCountDTO soldProducts;

}
