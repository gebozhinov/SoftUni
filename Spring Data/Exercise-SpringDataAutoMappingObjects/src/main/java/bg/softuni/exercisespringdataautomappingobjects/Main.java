package bg.softuni.exercisespringdataautomappingobjects;

import bg.softuni.exercisespringdataautomappingobjects.model.dto.GameInfoDTO;
import bg.softuni.exercisespringdataautomappingobjects.model.entities.User;
import bg.softuni.exercisespringdataautomappingobjects.service.game.GameService;
import bg.softuni.exercisespringdataautomappingobjects.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

import static bg.softuni.exercisespringdataautomappingobjects.Constant.Validation.USER_REGISTERED;

@Component
public class Main implements CommandLineRunner {

    private final UserService userService;
    private final GameService gameService;
    private final Scanner scanner;
    private User loggedUser;

    @Autowired
    public Main(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run(String... args) throws Exception {

        String[] input = scanner.nextLine().split("\\|");
        while (!input[0].equals("Logout")) {
            String command = input[0];
            switch (command) {
                case "RegisterUser" -> {
                    userService.register(input);
                    System.out.printf(USER_REGISTERED + "%n", input[4]);
                }
                case "LoginUser" -> {
                    userService.login(input);
                    this.loggedUser = this.userService.findByEmail(input[1]);
                }
                case "AddGame" -> {
                    if (isAdminLogged()) {
                        gameService.add(input);
                        System.out.printf("Added %s%n", input[1]);
                    }
                }
                case "EditGame" -> {
                    if (isAdminLogged()) {
                        this.gameService.edit(input);
                        System.out.printf("Edited %s%n",
                                this.gameService.findById(Long.parseLong(input[1])).getTitle());
                    }
                }
                case "DeleteGame" -> {
                    if (isAdminLogged()) {
                        long id = Long.parseLong(input[1]);
                        System.out.printf("Deleted %s%n",
                                this.gameService.delete(id));
                    }
                }
                case "AllGames" -> this.gameService.findAllGames().
                        stream()
                        .map(GameInfoDTO::toString)
                        .forEach(System.out::println);
                case "DetailGame" -> {
                    String title = input[1];
                    System.out.println(this.gameService.findGameDetails(title).toString());
                }
                case "OwnedGames" -> {
                    if (loggedUser != null) {
                        this.userService.findOwnedGames().
                        forEach(System.out::println);
                    }
                }
                case "AddItem" -> {
                    if (loggedUser != null) {
                        String title = input[1];
                        this.userService.addItem(title);
                        System.out.printf("%s added to cart.%n", title);
                    }
                }
                case "RemoveItem" -> {
                    if (loggedUser != null) {
                        String title = input[1];
                        this.userService.removeItem(title);
                        System.out.printf("%s removed from cart.%n", title);
                    }
                }
                case "BuyItem" -> {
                    if (loggedUser != null) {
                        System.out.println("Successfully bought games:");
                        System.out.println(this.userService.buyItem());
                    }
                }
            }

            input = scanner.nextLine().split("\\|");
        }
        System.out.println(this.userService.logout());

    }

    private boolean isAdminLogged() {
        return loggedUser != null && loggedUser.isAdmin();
    }

}
