package bg.softuni.mobilelele;

import bg.softuni.mobilelele.service.DataInitService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements CommandLineRunner {

    private final DataInitService dataInitService;

    public DataInit(DataInitService dataInitService) {
        this.dataInitService = dataInitService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.dataInitService.dataInit();
    }
}
