package bg.softuni.cardealer.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PartDTO {

    private String name;
    private BigDecimal price;
    private int quantity;
    private SupplierDTO supplierDTO;
}
