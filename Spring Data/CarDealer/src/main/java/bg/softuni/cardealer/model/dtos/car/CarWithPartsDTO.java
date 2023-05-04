package bg.softuni.cardealer.model.dtos.car;

import bg.softuni.cardealer.model.dtos.car.wrapper.PartBaseInfoWrapper;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarWithPartsDTO {

    @XmlAttribute
    private String make;
    @XmlAttribute
    private String model;
    @XmlAttribute
    private long travelledDistance;
    @XmlElement(name = "parts")
    private PartBaseInfoWrapper parts;
}
