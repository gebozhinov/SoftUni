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
    public static final Path EXPORT_LOCAL_SUPPLIERS =
            Path.of("src", "main", "resources", "output", "local-suppliers.json");
    public static final Path EXPORT_CARS_WITH_PARTS =
            Path.of("src", "main", "resources", "output", "cars-with-parts.json");
    public static final Path TOTAL_SALES_BY_CUSTOMER =
            Path.of("src", "main", "resources", "output", "customers-total-sales.json");
    public static final Path SALES_WITH_APPLIED_DISCOUNT =
            Path.of("src", "main", "resources", "output", "sales-discounts.json");


    // XML Files
    public static final Path IMPORT_SUPPLIERS_PATH_XML =
            Path.of("src", "main", "resources", "seedDb", "xmls", "suppliers.xml");
    public static final Path IMPORT_PARTS_PATH_XML =
            Path.of("src", "main", "resources", "seedDb", "xmls", "parts.xml");
    public static final Path IMPORT_CARS_PATH_XML =
            Path.of("src", "main", "resources", "seedDb", "xmls", "cars.xml");
    public static final Path IMPORT_CUSTOMERS_PATH_XML =
            Path.of("src", "main", "resources", "seedDb", "xmls", "customers.xml");
}
