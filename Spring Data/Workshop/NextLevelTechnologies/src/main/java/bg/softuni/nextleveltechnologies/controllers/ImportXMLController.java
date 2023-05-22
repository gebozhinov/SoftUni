package bg.softuni.nextleveltechnologies.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ImportXMLController {


    @GetMapping("import/xml")
    public String importXML(Model model) {

        boolean[] importedStatus = {false, false, false};
        model.addAttribute("areImported", importedStatus);
        return "xml/import-xml";
    }

    @GetMapping("import/companies")
    public String importCompanies() {
        return "xml/import-companies";
    }
}
