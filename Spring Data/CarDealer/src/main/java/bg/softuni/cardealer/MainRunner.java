package bg.softuni.cardealer;

import bg.softuni.cardealer.service.CarService;
import bg.softuni.cardealer.service.CustomerService;
import bg.softuni.cardealer.service.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MainRunner implements CommandLineRunner {

    private final SeedService seedService;
    private final CustomerService customerService;
    private final CarService carService;

    @Autowired
    public MainRunner(SeedService seedService, CustomerService customerService, CarService carService) {
        this.seedService = seedService;
        this.customerService = customerService;
        this.carService = carService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.seedService.seedDatabase();
        customerService.getAllCustomers();
        carService.findAllByMakeOrderByModelAscTravelledDistanceDesc("Toyota");
    }
}
