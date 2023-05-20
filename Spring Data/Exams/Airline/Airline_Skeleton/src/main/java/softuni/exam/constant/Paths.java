package softuni.exam.constant;

import java.nio.file.Path;

public enum Paths {
    ;
    public static final Path IMPORT_TOWNS_PATH = Path.of("src/main/resources/files/json/towns.json");
    public static final Path IMPORT_PASSENGERS_PATH = Path.of("src/main/resources/files/json/passengers.json");
    public static final Path IMPORT_PLANES_PATH = Path.of("src/main/resources/files/xml/planes.xml");
    public static final Path IMPORT_TICKETS_PATH = Path.of("src/main/resources/files/xml/tickets.xml");
}
