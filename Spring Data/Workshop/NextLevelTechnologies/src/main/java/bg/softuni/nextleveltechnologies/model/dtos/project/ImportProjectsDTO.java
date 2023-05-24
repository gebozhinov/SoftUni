package bg.softuni.nextleveltechnologies.model.dtos.project;

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
@XmlRootElement(name = "projects")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportProjectsDTO {

    @XmlElement(name = "project")
    private List<ImportProjectDTO> projects;
}
