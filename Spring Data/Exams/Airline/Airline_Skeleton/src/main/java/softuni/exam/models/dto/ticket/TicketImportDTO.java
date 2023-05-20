package softuni.exam.models.dto.ticket;

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
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "ticket")
@XmlAccessorType(XmlAccessType.FIELD)
public class TicketImportDTO {

    @Size(min = 2)
    @XmlElement(name = "serial-number")
    private String serialNumber;
    @Min(0)
    @XmlElement
    private BigDecimal price;
    @XmlElement(name = "take-off")
    private String takeOff;

    @XmlElement(name = "from-town")
    private TicketFromTownWrapper fromTown;

    @XmlElement(name = "to-town")
    private TicketToTownWrapper toTown;

    @XmlElement
    private TicketPassengerEmailWrapper passenger;

    @XmlElement
    private TicketPlaneRegisteredNumberWrapper plane;

}
