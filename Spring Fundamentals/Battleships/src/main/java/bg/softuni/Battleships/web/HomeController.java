package bg.softuni.Battleships.web;

import bg.softuni.Battleships.model.dto.ShipDTO;
import bg.softuni.Battleships.service.ShipService;
import bg.softuni.Battleships.user.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

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
    @GetMapping("/home")
    public String home() {

        if (sessionUser.isLogged()) {

            return "/home";
        } else {
            return "redirect:/";
        }
    }
}
