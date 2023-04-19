package bg.softuni.cardealer;

import bg.softuni.cardealer.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MainRunner implements CommandLineRunner {

    private final SeedService seedService;
    private final CustomerService customerService;
    private final CarService carService;
    private final SupplierService supplierService;
    private final SaleService saleService;

    @Autowired
    public MainRunner(SeedService seedService,
                      CustomerService customerService,
                      CarService carService,
                      SupplierService supplierService,
                      SaleService saleService) {
        this.seedService = seedService;
        this.customerService = customerService;
        this.carService = carService;
        this.supplierService = supplierService;
        this.saleService = saleService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.seedService.seedDatabase();
        customerService.getAllCustomers();
        carService.findAllByMakeOrderByModelAscTravelledDistanceDesc("Toyota");
        supplierService.findAllByImporterIsFalse();
        carService.findAllWithParts();
        customerService.getTotalSalesByCustomer();
        saleService.getAll();
    }
}
