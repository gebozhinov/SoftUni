package bg.softuni.cardealer.model.dtos.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SoldCarDTO {
    private String make;
    private String model;
    private long travelledDistance;

}
