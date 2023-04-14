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
}
