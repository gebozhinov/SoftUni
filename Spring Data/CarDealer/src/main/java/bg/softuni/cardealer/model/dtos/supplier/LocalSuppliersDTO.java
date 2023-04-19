package bg.softuni.cardealer.model.dtos.supplier;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocalSuppliersDTO {

    private Long id;
    private String name;
    private int partsCount;


}
