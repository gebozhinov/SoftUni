package bg.softuni.Battleships.model.mapper;

import bg.softuni.Battleships.model.Ship;
import bg.softuni.Battleships.model.dto.ShipDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShipMapper {


    List<ShipDTO> shipsToShipsDTO(List<Ship> ships);

}
