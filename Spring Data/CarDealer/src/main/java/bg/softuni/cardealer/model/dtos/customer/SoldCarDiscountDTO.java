package bg.softuni.cardealer.model.dtos.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SoldCarDiscountDTO {

    private double discount;

    private SoldCarDTO car;

}
