package bg.softuni.cardealer.model.dtos.car.wrapper;

import bg.softuni.cardealer.model.dtos.car.PartBaseInfoDTO;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "parts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartBaseInfoWrapper {

    @XmlElement(name = "parts")
    private List<PartBaseInfoDTO> parts;
}
