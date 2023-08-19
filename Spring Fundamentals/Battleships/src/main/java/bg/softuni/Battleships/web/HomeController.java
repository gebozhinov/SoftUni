package bg.softuni.Battleships.web;

import bg.softuni.Battleships.model.dto.BattleDTO;
import bg.softuni.Battleships.model.dto.ShipDTO;
import bg.softuni.Battleships.service.ShipService;
import bg.softuni.Battleships.user.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class HomeController {

    private final ShipService shipService;
    private final SessionUser sessionUser;

    public HomeController(ShipService shipService,
                          SessionUser sessionUser) {
        this.shipService = shipService;
        this.sessionUser = sessionUser;
    }

    @ModelAttribute("ownerShips")
    public List<ShipDTO> owenShips() {
        return this.shipService.getOwnerShips();
    }

    @ModelAttribute("enemyShips")
    public List<ShipDTO> enemyShips() {
        return this.shipService.getEnemyShips();
    }

    @ModelAttribute("allShips")
    public List<ShipDTO> allShips() {
        return this.shipService.getAllShips();
    }

    @ModelAttribute
    public BattleDTO battleDTO() {
        return new BattleDTO();
    }

    @GetMapping("/")
    public String index() {
        if (sessionUser.isLogged()) {
            return "redirect:/home";
        }
        return "index";
    }
    @GetMapping("/home")
    public String home(RedirectAttributes redirectAttributes) {

        if (sessionUser.isLogged()) {

            redirectAttributes.addFlashAttribute("ownerShips", this.shipService.getOwnerShips());
            redirectAttributes.addFlashAttribute("enemyShip", this.shipService.getEnemyShips());

            return "/home";
        } else {
            return "redirect:/";
        }
    }
}
