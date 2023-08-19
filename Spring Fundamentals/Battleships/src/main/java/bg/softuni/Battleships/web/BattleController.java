package bg.softuni.Battleships.web;


import bg.softuni.Battleships.model.dto.BattleDTO;
import bg.softuni.Battleships.service.ShipService;
import bg.softuni.Battleships.user.SessionUser;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class BattleController {

    private final ShipService shipService;

    private final SessionUser sessionUser;
    public BattleController(ShipService shipService,
                            SessionUser sessionUser) {
        this.shipService = shipService;
        this.sessionUser = sessionUser;
    }

    @PostMapping("/home")
    public String battle(@Valid BattleDTO battleDTO, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {

        if (!sessionUser.isLogged()) {
            return "redirect:/";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("battleDTO", battleDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.battleDTO",
                    bindingResult);
            return "redirect:/home";
        }

        this.shipService.battle(battleDTO);

        return "redirect:/home";
    }


}
