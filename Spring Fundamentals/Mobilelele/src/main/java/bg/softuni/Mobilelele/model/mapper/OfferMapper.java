package bg.softuni.Mobilelele.model.mapper;

import bg.softuni.Mobilelele.model.dto.AddOfferDTO;
import bg.softuni.Mobilelele.model.entity.OfferEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OfferMapper {


    @Mapping(source = "imageURL", target = "imageURL")
    OfferEntity addOfferDTOToOfferEntity(AddOfferDTO addOfferDTO);

}
