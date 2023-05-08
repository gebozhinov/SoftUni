package softuni.exam.constants;

import java.nio.file.Path;

public enum Paths {
    ;
    public static final Path IMPORT_COUNTRIES_PATH =
            Path.of("src/main/resources/files/json/countries.json");
    public static final Path IMPORT_CITIES_PATH =
            Path.of("src/main/resources/files/json/cities.json");

    public static final Path IMPORT_FORECASTS_PATH =
            Path.of("src/main/resources/files/xml/forecasts.xml");
}
