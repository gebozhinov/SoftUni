package softuni.exam.instagraphlite.models.dto.post;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "post")
@XmlAccessorType(XmlAccessType.FIELD)
public class PostImportDTO {

    @NotNull
    @Size(min = 21)
    @XmlElement
    private String caption;

    @XmlElement
    private UserUsernameWrapper user;

    @XmlElement
    private PicturePathWrapper picture;

}
