package bg.softuni.nextleveltechnologies.service;

import bg.softuni.nextleveltechnologies.model.dtos.company.ImportCompaniesDTO;
import bg.softuni.nextleveltechnologies.model.enitities.Company;
import bg.softuni.nextleveltechnologies.repositories.CompanyRepository;
import bg.softuni.nextleveltechnologies.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static bg.softuni.nextleveltechnologies.constant.Message.INCORRECT_DATA;
import static bg.softuni.nextleveltechnologies.constant.Message.SUCCESSFULLY_IMPORTED_COMPANY;
import static bg.softuni.nextleveltechnologies.constant.Paths.IMPORT_COMPANIES_PATH;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public CompanyServiceImpl(CompanyRepository companyRepository,
                              ModelMapper modelMapper,
                              ValidationUtil validationUtil) {
        this.companyRepository = companyRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public String getXMLContent() throws IOException {

        return Files.readString(IMPORT_COMPANIES_PATH);
    }

    @Override
    public String importCompanies() throws JAXBException {

        StringBuilder sb = new StringBuilder();

        File file = IMPORT_COMPANIES_PATH.toFile();

        JAXBContext context = JAXBContext.newInstance(ImportCompaniesDTO.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        ImportCompaniesDTO unmarshal = (ImportCompaniesDTO) unmarshaller.unmarshal(file);
        unmarshal.getCompanies()
                .forEach(importCompanyDTO -> {
                    boolean isValid = validationUtil.isValid(importCompanyDTO);

                    if (isValid) {
                        Company company = modelMapper.map(importCompanyDTO, Company.class);
                        this.companyRepository.saveAndFlush(company);
                        sb.append(String.format(SUCCESSFULLY_IMPORTED_COMPANY,
                                        company.getName()))
                                .append(System.lineSeparator());
                    } else {
                        sb.append(String.format(INCORRECT_DATA, "Company"))
                                .append(System.lineSeparator());
                    }

                });

        return sb.toString().trim();
    }

    @Override
    public boolean areImported() {
        return this.companyRepository.count() > 0;
    }
}
