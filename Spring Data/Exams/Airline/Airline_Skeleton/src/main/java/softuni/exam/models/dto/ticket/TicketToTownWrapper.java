package softuni.exam.models.dto.ticket;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "to-town")
@XmlAccessorType(XmlAccessType.FIELD)
public class TicketToTownWrapper {

    @XmlElement
    private String name;

}
