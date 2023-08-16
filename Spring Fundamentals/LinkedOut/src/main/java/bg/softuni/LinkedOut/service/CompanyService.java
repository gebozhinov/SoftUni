package bg.softuni.LinkedOut.service;

import bg.softuni.LinkedOut.model.dto.AddCompanyDTO;
import bg.softuni.LinkedOut.model.entity.Company;
import bg.softuni.LinkedOut.model.mapper.CompanyMapper;
import bg.softuni.LinkedOut.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    public CompanyService(CompanyRepository companyRepository,
                          CompanyMapper companyMapper) {
        this.companyRepository = companyRepository;
        this.companyMapper = companyMapper;
    }

    public void addCompany(AddCompanyDTO addCompanyDTO) {

        Company company = this.companyMapper.addCompanyDTOToCompany(addCompanyDTO);
        this.companyRepository.save(company);

    }


    public List<String> findAllCompanyNames() {
        return this.companyRepository.findAllCompanyNames().orElse(null);
    }
}
