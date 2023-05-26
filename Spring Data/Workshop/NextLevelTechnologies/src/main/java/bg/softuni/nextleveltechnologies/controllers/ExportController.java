package bg.softuni.nextleveltechnologies.controllers;

import bg.softuni.nextleveltechnologies.service.EmployeeService;
import bg.softuni.nextleveltechnologies.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExportController {

    private final ProjectService projectService;
    private final EmployeeService employeeService;

    public ExportController(ProjectService projectService,
                            EmployeeService employeeService) {
        this.projectService = projectService;
        this.employeeService = employeeService;
    }

    @GetMapping("/export/project-if-finished")
    public String exportFinishedProjects(Model model) {

        String projects = projectService.findAllByFinished();
        model.addAttribute("projectsIfFinished", projects);

        return "export/export-project-if-finished";
    }

    @GetMapping("export/employees-above")
    public String exportEmployees(Model model) {

        String employees = employeeService.findAllByAgeAfter(25);
        model.addAttribute("employeesAbove", employees);

        return "export/export-employees-with-age";
    }

}
