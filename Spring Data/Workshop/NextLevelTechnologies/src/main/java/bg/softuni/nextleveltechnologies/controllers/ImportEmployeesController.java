package bg.softuni.nextleveltechnologies.controllers;

import bg.softuni.nextleveltechnologies.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Controller
public class ImportEmployeesController {

    private final EmployeeService employeeService;

    public ImportEmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("import/employees")
    private String viewImportEmployees(Model model) throws IOException {

        String employees = employeeService.getXMLContent();
        model.addAttribute("employees", employees);

        return "xml/import-employees";
    }

    @PostMapping("import/employees")
    private String importEmployees() throws JAXBException {

        this.employeeService.importEmployees();
        return "redirect:/import/xml";
    }
}
