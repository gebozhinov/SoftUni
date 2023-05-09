package softuni.exam.models.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "offer")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportOfferDTO {

    @Min(0)
    @XmlElement
    private BigDecimal price;

    @XmlElement
    private AgentNameWrapper agent;

    @XmlElement
    private ApartmentIdWrapper apartment;

    @XmlElement
    private String publishedOn;

}
