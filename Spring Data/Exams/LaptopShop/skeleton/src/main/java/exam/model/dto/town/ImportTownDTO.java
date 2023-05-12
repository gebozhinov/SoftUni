package exam.model.dto.town;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "town")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportTownDTO {

    @Size(min = 2)
    @XmlElement
    private String name;
    @Min(1)
    @XmlElement
    private Integer population;
    @Size(min = 10)
    @XmlElement(name = "travel-guide")
    private String travelGuide;

}
