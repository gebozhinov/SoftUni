package exam.constant;

import java.nio.file.Path;

public enum Paths {
    ;

    public static final Path IMPORT_TOWNS_PATH = Path.of("src/main/resources/files/xml/towns.xml");
    public static final Path IMPORT_SHOPS_PATH = Path.of("src/main/resources/files/xml/shops.xml");
    public static final Path IMPORT_CUSTOMERS_PATH = Path.of("src/main/resources/files/json/customers.json");
    public static final Path IMPORT_LAPTOPS_PATH = Path.of("src/main/resources/files/json/laptops.json");
}
