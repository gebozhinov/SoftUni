package softuni.exam.models.dto.plane;

import com.google.gson.annotations.Expose;
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
@XmlRootElement(name = "plane")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlaneImportDTO {
    @Size(min = 5)
    @XmlElement(name = "register-number")
    private String registeredNumber;

    @Min(0)
    @XmlElement
    private Integer capacity;

    @Size(min = 2)
    @XmlElement
    private String airline;

}
