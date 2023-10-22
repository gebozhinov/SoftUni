package bg.softuni.Pathfinder;

import bg.softuni.Pathfinder.model.User;
import bg.softuni.Pathfinder.repository.AuthRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Init implements CommandLineRunner {

    private final AuthRepository authRepository;

    public Init(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        User admin = this.authRepository.findByUsername("admin").get();
        User test2 = this.authRepository.findByUsername("test2").get();
        System.out.printf("");

    }
}
