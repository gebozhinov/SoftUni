package bg.softuni.cardealer.service;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface SeedService {

    void seedSuppliers() throws IOException;
    void seedParts() throws IOException;
    void seedCars() throws IOException;
    void seedCustomers() throws IOException;
    void seedSales();

    default void seedDatabase() throws IOException {
        seedSuppliers();
        seedParts();
        seedCars();
        seedCustomers();
        seedSales();
    }

}
