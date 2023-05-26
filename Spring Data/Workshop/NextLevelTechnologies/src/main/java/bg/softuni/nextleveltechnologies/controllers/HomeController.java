package bg.softuni.nextleveltechnologies.controllers;

import bg.softuni.nextleveltechnologies.service.CompanyService;
import bg.softuni.nextleveltechnologies.service.EmployeeService;
import bg.softuni.nextleveltechnologies.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CompanyService companyService;
    private final EmployeeService employeeService;
    private final ProjectService projectService;

    public HomeController(CompanyService companyService,
                          EmployeeService employeeService,
                          ProjectService projectService) {
        this.companyService = companyService;
        this.employeeService = employeeService;
        this.projectService = projectService;
    }

    @GetMapping("/")
    public String index() {

        return "index";
    }

    @GetMapping("home")
    public String home(Model model) {

        boolean areImported = companyService.areImported() &&
                employeeService.areImported() &&
                projectService.areImported();

        model.addAttribute("areImported", areImported);

        return "home";
    }
}
