package bg.softuni.cardealer.model.dtos.supplier.wrapper;

import bg.softuni.cardealer.model.dtos.supplier.LocalSuppliersDTO;
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
@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class LocalSuppliersWrapper {

    @XmlElement(name = "supplier")
    private List<LocalSuppliersDTO> suppliers;

}
