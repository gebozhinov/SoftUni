package bg.softuni.nextleveltechnologies.controllers;

import bg.softuni.nextleveltechnologies.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Controller
public class ImportProjectsController {

    private final ProjectService projectService;

    public ImportProjectsController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("import/projects")
    public String viewImportProjects(Model model) throws IOException {

        String projects = projectService.getXMLContent();
        model.addAttribute("projects", projects);

        return "xml/import-projects";
    }

    @PostMapping("import/projects")
    public String importProjects() throws JAXBException {

            projectService.importProjects();

        return "redirect:/import/xml";
    }
}
