package bg.softuni.LinkedOut.model.mapper;

import bg.softuni.LinkedOut.model.dto.AddCompanyDTO;
import bg.softuni.LinkedOut.model.entity.Company;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper {


    Company addCompanyDTOToCompany(AddCompanyDTO addCompanyDTO);

}
