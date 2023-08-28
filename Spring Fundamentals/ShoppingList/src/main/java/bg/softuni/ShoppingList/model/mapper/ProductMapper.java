package bg.softuni.ShoppingList.model.mapper;

import bg.softuni.ShoppingList.model.dto.AddProductDTO;
import bg.softuni.ShoppingList.model.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {



    @Mapping(target = "category", ignore = true)
    Product addProductDtoToProduct(AddProductDTO addProductDTO);

}
