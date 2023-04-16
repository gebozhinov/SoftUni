package bg.softuni.exercisejson.model.dtos.user;

import bg.softuni.exercisejson.model.dtos.product.ProductAllInfoDTO;
import bg.softuni.exercisejson.model.dtos.product.ProductInfoDTO;
import bg.softuni.exercisejson.model.dtos.product.ProductSoldCountDTO;
import bg.softuni.exercisejson.model.entities.Product;
import bg.softuni.exercisejson.model.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String firstName;
    private String lastName;
    private int age;
    private Set<ProductAllInfoDTO> productsSold;
    private Set<ProductAllInfoDTO> productsBought;
    private Set<User> friends;


    public UserAndProductDTO toUserAndProductDTO () {
        return new UserAndProductDTO(firstName, lastName, age, toProductSoldCountDTO());
    }
    public ProductSoldCountDTO toProductSoldCountDTO () {
        return new ProductSoldCountDTO(productsSold
                .stream()
                .map(this::toProductInfoDTO)
                .collect(Collectors.toList()));
    }
    public ProductInfoDTO toProductInfoDTO (ProductAllInfoDTO productAllInfoDTO) {
        return new ProductInfoDTO(productAllInfoDTO.getName(), productAllInfoDTO.getPrice());
    }
}
