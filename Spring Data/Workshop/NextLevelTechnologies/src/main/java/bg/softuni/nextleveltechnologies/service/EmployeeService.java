package bg.softuni.nextleveltechnologies.service;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface EmployeeService {

    String getXMLContent() throws IOException;

    String importEmployees() throws JAXBException;

    boolean areImported();

}
