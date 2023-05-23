package bg.softuni.nextleveltechnologies.model.dtos.company;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "companies")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportCompaniesDTO {

    @XmlElement(name = "company")
    private List<ImportCompanyDTO> companies;

}
