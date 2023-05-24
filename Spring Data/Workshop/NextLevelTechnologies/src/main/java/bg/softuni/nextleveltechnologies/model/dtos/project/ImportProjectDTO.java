package bg.softuni.nextleveltechnologies.model.dtos.project;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "project")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportProjectDTO {

    @XmlElement
    private String name;
    @XmlElement
    private String description;

    @XmlElement(name = "start-date")
    private String startDate;

    @XmlElement(name = "is-finished")
    private String isFinished;

    @XmlElement
    private BigDecimal payment;

    @XmlElement
    private CompanyNameDTO company;
}
