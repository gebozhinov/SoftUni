package bg.softuni.cardealer.model.dtos.sale;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleDTO {

    private SaleCarDTO car;

    private String customerName;
    private double discount;
    private BigDecimal price;
    private BigDecimal priceWithDiscount;

}
