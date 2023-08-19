package bg.softuni.Battleships.web;

import bg.softuni.Battleships.model.dto.AddShipDTO;
import bg.softuni.Battleships.service.ShipService;
import bg.softuni.Battleships.user.SessionUser;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ShipController {

    private final ShipService shipService;
    private final SessionUser sessionUser;

    public ShipController(ShipService shipService,
                          SessionUser sessionUser) {
        this.shipService = shipService;
        this.sessionUser = sessionUser;
    }

    @ModelAttribute("addShip")
    public AddShipDTO addShipDTO() {
        return new AddShipDTO();
    }

    @GetMapping("/ship/add")
    public String add() {
        if (!sessionUser.isLogged()) {
            return "redirect:/";
        }

        return "/ship-add";
    }

    @PostMapping("/ship/add")
    public String add(@Valid AddShipDTO addShipDTO, BindingResult bindingResult,
                      RedirectAttributes redirectAttributes) {

        if (!sessionUser.isLogged()) {
            return "redirect:/";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addShip", addShipDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addShip",
                    bindingResult);
            return "redirect:/ship/add";

        }

        this.shipService.addShip(addShipDTO);

        return "redirect:/home";
    }
}
