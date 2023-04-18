package bg.softuni.cardealer.model.dtos.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private String name;

    private String birthDate;
    private boolean isYoungDriver;

    private Set<SoldCarDiscountDTO> sales;


}
