package bg.softuni.exercisejson.config;

import java.nio.file.Path;

public enum Paths {
    ;
    public static final Path SEED_USERS_PATH =
            Path.of("src", "main", "resources", "dbContent", "users.json");
    public static final Path SEED_CATEGORIES_PATH =
            Path.of("src", "main", "resources", "dbContent", "categories.json");
    public static final Path SEED_PRODUCTS_PATH =
            Path.of("src", "main", "resources", "dbContent", "products.json");

    public static final Path EXPORT_PRODUCTS_WITH_NO_BUYERS_IN_PRICE_RANGE =
            Path.of("src", "main", "resources", "output", "products-with-no-buyer-in-price-range.json");
}
