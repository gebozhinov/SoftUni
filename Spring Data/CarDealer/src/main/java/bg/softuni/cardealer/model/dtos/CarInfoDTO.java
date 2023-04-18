package bg.softuni.cardealer.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarInfoDTO  {

    private long id;
    private String make;
    private String model;
    private long travelledDistance;
}
