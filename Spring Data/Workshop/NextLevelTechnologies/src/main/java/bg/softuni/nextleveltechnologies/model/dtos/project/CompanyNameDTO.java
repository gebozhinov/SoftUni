package bg.softuni.nextleveltechnologies.model.dtos.project;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "name")
@XmlAccessorType(XmlAccessType.FIELD)
public class CompanyNameDTO {

    @XmlAttribute
    private String name;
}
