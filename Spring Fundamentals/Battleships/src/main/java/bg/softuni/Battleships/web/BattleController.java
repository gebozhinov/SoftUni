package bg.softuni.Battleships.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class BattleController {



    @PostMapping("/home")
    public String battle() {

        return "/home";
    }


}
