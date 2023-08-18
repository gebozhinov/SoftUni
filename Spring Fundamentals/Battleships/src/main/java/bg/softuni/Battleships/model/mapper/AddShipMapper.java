package bg.softuni.Battleships.model.mapper;

import bg.softuni.Battleships.model.Ship;
import bg.softuni.Battleships.model.dto.AddShipDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddShipMapper {

    @Mapping(target = "category", ignore = true)
    Ship addShipDTOToShip(AddShipDTO addShipDTO);

}
