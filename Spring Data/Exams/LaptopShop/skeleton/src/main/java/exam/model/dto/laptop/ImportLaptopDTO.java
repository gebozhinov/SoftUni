package exam.model.dto.laptop;

import exam.model.entity.enums.WarrantyType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ImportLaptopDTO {

    @Size(min = 9)
    private String macAddress;
    @DecimalMin(value = "0")
    private Double cpuSpeed;

    @Min(8)
    @Max(128)
    private Integer ram;

    @Min(128)
    @Max(1024)
    private Integer storage;

    @Size(min = 10)
    private String description;

    @DecimalMin(value = "0")
    private BigDecimal price;

    private String warrantyType;

    private ShopNameDTO shop;

}
