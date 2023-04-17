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


}
