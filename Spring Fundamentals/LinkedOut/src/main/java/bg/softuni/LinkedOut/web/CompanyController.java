package bg.softuni.LinkedOut.web;

import bg.softuni.LinkedOut.model.dto.AddCompanyDTO;
import bg.softuni.LinkedOut.service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/companies")
public class CompanyController {


    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @ModelAttribute("addCompanyDTO")
    public AddCompanyDTO addCompanyDTO() {
        return new AddCompanyDTO();
    }

    @GetMapping("/add")
    public String addCompany() {
        return "company-add";
    }

    @PostMapping("/add")
    public String addCompany(@Valid AddCompanyDTO addCompanyDTO, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("addCompanyDTO", addCompanyDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addCompanyDTO",
                    bindingResult);

            return "redirect:/companies/add";
        }


        this.companyService.addCompany(addCompanyDTO);

        return "redirect:/";
    }

}
