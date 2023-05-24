package bg.softuni.nextleveltechnologies.service;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface ProjectService {

    String getXMLContent() throws IOException;

    String importProjects() throws JAXBException;

    boolean areImported();
}
