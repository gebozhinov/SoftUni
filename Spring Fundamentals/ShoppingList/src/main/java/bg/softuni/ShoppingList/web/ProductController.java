package bg.softuni.ShoppingList.web;

import bg.softuni.ShoppingList.model.dto.AddProductDTO;
import bg.softuni.ShoppingList.service.ProductService;
import bg.softuni.ShoppingList.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    private final UserService userService;

    public ProductController(ProductService productService,
                             UserService userService) {
        this.productService = productService;
        this.userService = userService;
    }

    @ModelAttribute("addProduct")
    public AddProductDTO addProductDTO() {
        return new AddProductDTO();
    }

    @GetMapping("/add")
    public String add() {
        if (!this.userService.isLogged()) {
            return "redirect:/";
        }
        return "/product-add";
    }

    @PostMapping("/add")
    public String add(@Valid AddProductDTO addProductDTO, BindingResult bindingResult,
                      RedirectAttributes redirectAttributes) {

        if (!this.userService.isLogged()) {
            return "redirect:/";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addProduct", addProductDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addProduct",
                    bindingResult);
            return "redirect:/product/add";
        }

        this.productService.add(addProductDTO);

        return "/home";
    }
}
