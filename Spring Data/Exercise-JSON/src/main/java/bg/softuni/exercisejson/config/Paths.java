package bg.softuni.exercisejson.config;

import java.nio.file.Path;

public enum Paths {
    ;
    public static final Path SEED_USERS_PATH =
            Path.of("src", "main", "resources", "dbContent", "json", "users.json");
    public static final Path SEED_CATEGORIES_PATH =
            Path.of("src", "main", "resources", "dbContent", "json", "categories.json");
    public static final Path SEED_PRODUCTS_PATH =
            Path.of("src", "main", "resources", "dbContent", "json", "products.json");

    public static final Path EXPORT_PRODUCTS_WITH_NO_BUYERS_IN_PRICE_RANGE =
            Path.of("src", "main", "resources", "output", "json", "products-with-no-buyer-in-price-range.json");

    public static final Path EXPORT_USERS_WITH_MIN_ONE_PRODUCT_SOLD =
            Path.of("src", "main", "resources", "output", "json", "users-with-min-one-product-sold.json");

    public static final Path EXPORT_CATEGORIES_BY_PRODUCTS_COUNT =
            Path.of("src", "main", "resources", "output", "json", "categories-by-products-count.json");

    public static final Path EXPORT_USERS_AND_PRODUCTS =
            Path.of("src", "main", "resources", "output", "json", "users-and-products.json");


    public static final Path SEED_USERS_XML_PATH =
            Path.of("src", "main", "resources", "dbContent", "xml", "users.xml");
    public static final Path SEED_CATEGORIES_XML_PATH =
            Path.of("src", "main", "resources", "dbContent", "xml", "categories.xml");
    public static final Path SEED_PRODUCTS_XML_PATH =
            Path.of("src", "main", "resources", "dbContent", "xml", "products.xml");

    public static final Path EXPORT_PRODUCTS_WITH_NO_BUYERS_IN_PRICE_RANGE_XML =
            Path.of("src", "main", "resources", "output", "xml", "products-with-no-buyer-in-price-range.xml");

    public static final Path EXPORT_USERS_WITH_MIN_ONE_PRODUCT_SOLD_XML =
            Path.of("src", "main", "resources", "output", "xml", "users-with-min-one-product-sold.xml");

    public static final Path EXPORT_CATEGORIES_BY_PRODUCTS_COUNT_XML =
            Path.of("src", "main", "resources", "output", "xml", "categories-by-products-count.xml");

    public static final Path EXPORT_USERS_AND_PRODUCTS_XML =
            Path.of("src", "main", "resources", "output", "xml", "users-and-products.xml");
}
