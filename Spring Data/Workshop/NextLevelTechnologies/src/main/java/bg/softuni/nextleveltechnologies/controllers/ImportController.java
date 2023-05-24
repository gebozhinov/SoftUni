package bg.softuni.nextleveltechnologies.controllers;

import bg.softuni.nextleveltechnologies.service.CompanyService;
import bg.softuni.nextleveltechnologies.service.EmployeeService;
import bg.softuni.nextleveltechnologies.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ImportController {

    private final CompanyService companyService;
    private final ProjectService projectService;
    private final EmployeeService employeeService;

    public ImportController(CompanyService companyService,
                            ProjectService projectService,
                            EmployeeService employeeService) {
        this.companyService = companyService;
        this.projectService = projectService;
        this.employeeService = employeeService;
    }

    @GetMapping("import/xml")
    public String importXML(Model model) {

        boolean areCompaniesImported = this.companyService.areImported();
        boolean areProjectsImported = this.projectService.areImported();
        boolean areEmployeesImported = this.employeeService.areImported();

        boolean[] importedStatus = {areCompaniesImported, areProjectsImported, areEmployeesImported};
        model.addAttribute("areImported", importedStatus);
        return "xml/import-xml";
    }

}
