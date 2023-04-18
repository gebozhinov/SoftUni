package bg.softuni.cardealer.config;

import java.nio.file.Path;

public enum Paths {
    ;
    public static final Path IMPORT_SUPPLIERS_PATH =
            Path.of("src", "main", "resources", "seedDb", "suppliers.json");
    public static final Path IMPORT_PARTS_PATH =
            Path.of("src", "main", "resources", "seedDb", "parts.json");
    public static final Path IMPORT_CARS_PATH =
            Path.of("src", "main", "resources", "seedDb", "cars.json");
    public static final Path IMPORT_CUSTOMERS_PATH =
            Path.of("src", "main", "resources", "seedDb", "customers.json");

    public static final Path EXPORT_ORDERED_CUSTOMERS =
            Path.of("src", "main", "resources", "output", "ordered-customers.json");

    public static final Path CARS_FROM_MAKE_TOYOTA =
            Path.of("src", "main", "resources", "output", "cars-from-make-toyota.json");


}
