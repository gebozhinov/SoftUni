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

    public static final Path EXPORT_USERS_WITH_MIN_ONE_PRODUCT_SOLD =
            Path.of("src", "main", "resources", "output", "users-with-min-one-product-sold.json");

    public static final Path EXPORT_CATEGORIES_BY_PRODUCTS_COUNT =
            Path.of("src", "main", "resources", "output", "categories-by-products-count.json");

    public static final Path EXPORT_USERS_AND_PRODUCTS =
            Path.of("src", "main", "resources", "output", "users-and-products.json");
}
