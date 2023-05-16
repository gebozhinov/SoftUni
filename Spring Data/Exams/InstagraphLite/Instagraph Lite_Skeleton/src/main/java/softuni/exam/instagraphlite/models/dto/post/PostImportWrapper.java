package softuni.exam.instagraphlite.models.dto.post;

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
@XmlRootElement(name = "posts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PostImportWrapper {

    @XmlElement(name = "post")
    private List<PostImportDTO> posts;

}
