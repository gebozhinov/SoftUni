package bg.softuni.LinkedOut.web;

import bg.softuni.LinkedOut.model.dto.AddEmployeeDTO;
import bg.softuni.LinkedOut.service.CompanyService;
import bg.softuni.LinkedOut.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final CompanyService companyService;

    public EmployeeController(EmployeeService employeeService,
                              CompanyService companyService) {
        this.employeeService = employeeService;
        this.companyService = companyService;
    }

    @ModelAttribute("addEmployeeDTO")
    public AddEmployeeDTO addEmployeeDTO() {
        return new AddEmployeeDTO();
    }

    @ModelAttribute("companyNames")
    public List<String> companyNames() {
        return this.companyService.findAllCompanyNames();
    }

    @GetMapping("/add")
    public String addEmployee() {
        return "employee-add";
    }

    @PostMapping("/add")
    public String addEmployee(@Valid AddEmployeeDTO addEmployeeDTO,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("addEmployeeDTO", addEmployeeDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addEmployeeDTO",
                    bindingResult);

            return "redirect:/employees/add";
        }

        this.employeeService.addEmployee(addEmployeeDTO);

        return "redirect:/";

    }
}
