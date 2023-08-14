package bg.softuni.Mobilelele.model.mapper;

import bg.softuni.Mobilelele.model.dto.BrandDTO;
import bg.softuni.Mobilelele.model.dto.ModelDTO;
import bg.softuni.Mobilelele.model.entity.BrandEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BrandMapper {



    List<BrandDTO> brandEntityToBrandDTO(List<BrandEntity> brandEntity);


}
