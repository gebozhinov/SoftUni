package bg.softuni.nextleveltechnologies.service;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface CompanyService {

    String getXMLContent() throws IOException;

    String importCompanies() throws JAXBException;

    boolean areImported();
}
