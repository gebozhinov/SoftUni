package bg.softuni.cardealer.model.dtos.customer.wrapper;

import bg.softuni.cardealer.model.dtos.customer.CustomerTotalSaleDTO;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerTotalSaleWrapper {

    @XmlElement(name = "customer")
    private List<CustomerTotalSaleDTO> customers;

}