package bg.softuni.exercisespringdataautomappingobjects;

import bg.softuni.exercisespringdataautomappingobjects.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

import static bg.softuni.exercisespringdataautomappingobjects.Constant.Validation.USER_REGISTERED;

@Component
public class Main implements CommandLineRunner {

    private final UserService userService;
    private final Scanner scanner;

    @Autowired
    public Main(UserService userService) {
        this.userService = userService;
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
                case "LoginUser" -> userService.login(input);
            }

            input = scanner.nextLine().split("\\|");
        }
        System.out.println(this.userService.logout());
    }
}
