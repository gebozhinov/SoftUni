package exam.model.dto.shop;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "shops")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportShopWrapper {

    @XmlElement(name = "shop")
    private List<ImportShopDTO> shops;

}
