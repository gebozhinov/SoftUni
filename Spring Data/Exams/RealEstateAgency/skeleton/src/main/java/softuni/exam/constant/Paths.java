package softuni.exam.constant;

import java.nio.file.Path;

public enum Paths {
    ;
    public static final Path IMPORT_TOWNS_PATH =
            Path.of("src/main/resources/files/json/towns.json");
    public static final Path IMPORT_AGENTS_PATH =
            Path.of("src/main/resources/files/json/agents.json");
    public static final Path IMPORT_APARMENTS_PATH =
            Path.of("src/main/resources/files/xml/apartments.xml");
    public static final Path IMPORT_OFFERS_PATH =
            Path.of("src/main/resources/files/xml/offers.xml");
}
