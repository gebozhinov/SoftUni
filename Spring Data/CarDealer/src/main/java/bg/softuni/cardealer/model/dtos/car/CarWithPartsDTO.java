package bg.softuni.cardealer.model.dtos.car;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarWithPartsDTO {

    private String make;
    private String model;
    private long travelledDistance;
    private Set<PartBaseInfoDTO> parts;
}
