package bg.softuni.nextleveltechnologies.constant;

import java.nio.file.Path;

public enum Paths {
    ;
    public static final Path IMPORT_COMPANIES_PATH =
            Path.of("src/main/resources/files/xmls/companies.xml");
    public static final Path IMPORT_PROJECTS_PATH =
            Path.of("src/main/resources/files/xmls/projects.xml");

    public static final Path IMPORT_EMPLOYEES_PATH =
            Path.of("src/main/resources/files/xmls/employees.xml");
}
