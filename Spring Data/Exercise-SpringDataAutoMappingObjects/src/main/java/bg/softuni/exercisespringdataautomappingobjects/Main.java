package bg.softuni.exercisespringdataautomappingobjects;

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
    private String loggedUserEmail;

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
                    this.loggedUserEmail = input[1];
                }
                case "AddGame" -> {
                    User user = this.userService.findByEmail(loggedUserEmail);
                    if (user != null && user.isAdmin()) {
                        gameService.add(input);
                        System.out.printf("Added %s%n", input[1]);
                    }
                }
                case "EditGame" -> {
                    User user = this.userService.findByEmail(loggedUserEmail);
                    if (user != null && user.isAdmin()) {
                        this.gameService.edit(input);
                        System.out.printf("Edited %s%n",
                                this.gameService.findById(Long.parseLong(input[1])).getTitle());
                    }
                }
                case "DeleteGame" -> {
                    User user = this.userService.findByEmail(loggedUserEmail);
                    if (user != null && user.isAdmin()) {
                        long id = Long.parseLong(input[1]);
                        System.out.printf("Deleted %s%n",
                                this.gameService.delete(id));
                    }
                }
            }

            input = scanner.nextLine().split("\\|");
        }
        System.out.println(this.userService.logout());

    }
}
