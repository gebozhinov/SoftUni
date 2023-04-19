package bg.softuni.cardealer.model.dtos.customer;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerTotalSaleDTO {

    @SerializedName(value = "fullName")
    private String name;
    private int boughtCars;
    private BigDecimal spentMoney;

}
