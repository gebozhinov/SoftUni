package bg.softuni.nextleveltechnologies.controllers;

import bg.softuni.nextleveltechnologies.service.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Controller
public class ImportCompaniesController {


    private final CompanyService companyService;

    public ImportCompaniesController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("import/companies")
    public String viewImportCompanies(Model model) throws IOException {

        String companies = this.companyService.getXMLContent();

        model.addAttribute("companies", companies);

        return "xml/import-companies";
    }

    @PostMapping("import/companies")
    public String importCompanies() throws JAXBException {

        this.companyService.importCompanies();

        return "redirect:/import/xml";
    }
}
