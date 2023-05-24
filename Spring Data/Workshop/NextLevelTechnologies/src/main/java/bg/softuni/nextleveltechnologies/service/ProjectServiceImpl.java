package bg.softuni.nextleveltechnologies.service;

import bg.softuni.nextleveltechnologies.model.dtos.project.ImportProjectsDTO;
import bg.softuni.nextleveltechnologies.model.enitities.Company;
import bg.softuni.nextleveltechnologies.model.enitities.Project;
import bg.softuni.nextleveltechnologies.repositories.CompanyRepository;
import bg.softuni.nextleveltechnologies.repositories.ProjectRepository;
import bg.softuni.nextleveltechnologies.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static bg.softuni.nextleveltechnologies.constant.Message.INCORRECT_DATA;
import static bg.softuni.nextleveltechnologies.constant.Message.SUCCESSFULLY_IMPORTED_PROJECT;
import static bg.softuni.nextleveltechnologies.constant.Paths.IMPORT_PROJECTS_PATH;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    private final CompanyRepository companyRepository;

    private final ModelMapper modelMapper;

    private final ValidationUtil validationUtil;

    public ProjectServiceImpl(ProjectRepository projectRepository,
                              CompanyRepository companyRepository, ModelMapper modelMapper,
                              ValidationUtil validationUtil) {
        this.projectRepository = projectRepository;
        this.companyRepository = companyRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public String getXMLContent() throws IOException {

        return Files.readString(IMPORT_PROJECTS_PATH);
    }

    @Override
    public String importProjects() throws JAXBException {

        StringBuilder sb = new StringBuilder();

        File file = IMPORT_PROJECTS_PATH.toFile();
        JAXBContext context = JAXBContext.newInstance(ImportProjectsDTO.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        ImportProjectsDTO importProjectsDTO = (ImportProjectsDTO) unmarshaller.unmarshal(file);
        importProjectsDTO.getProjects()
                .forEach(importProjectDTO -> {
                    boolean isValid = validationUtil.isValid(importProjectDTO);

                    Optional<Company> company =
                            companyRepository.getFirstByName(importProjectDTO.getCompany().getName());

                    if (company.isEmpty()) {
                        isValid = false;
                    }

                    if (isValid) {
                        Project project = modelMapper.map(importProjectDTO, Project.class);

                        project.setFinished(importProjectDTO.getIsFinished().equals("true"));

                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        String str = importProjectDTO.getStartDate();
                        LocalDate startDate = LocalDate.parse(str, formatter);
                        project.setStartDate(startDate);

                        project.setCompany(company.get());

                        projectRepository.saveAndFlush(project);

                        sb.append(String.format(SUCCESSFULLY_IMPORTED_PROJECT,
                                        project.getName()))
                                .append(System.lineSeparator());
                    } else {
                        sb.append(String.format(INCORRECT_DATA, "Project"))
                                .append(System.lineSeparator());
                    }
                });

        return sb.toString().trim();
    }

    @Override
    public boolean areImported() {
        return this.projectRepository.count() > 0;
    }


}
