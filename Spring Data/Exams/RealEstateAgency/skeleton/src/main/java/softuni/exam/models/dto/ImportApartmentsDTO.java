package softuni.exam.models.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.exam.models.entity.enums.ApartmentType;

import javax.validation.constraints.DecimalMin;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "apartment")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportApartmentsDTO {

    @XmlElement
    private ApartmentType apartmentType;
    @DecimalMin(value = "40")
    @XmlElement
    private Double area;
    @XmlElement
    private String town;

}
