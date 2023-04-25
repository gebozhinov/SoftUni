package bg.softuni.exercisejson.model.dtos.user.wrappers;

import bg.softuni.exercisejson.model.dtos.user.UserAndProductDTO;
import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserAndProductWrapperDTO {

    @XmlAttribute(name = "count")
    private Integer usersCount;
    @XmlElement(name = "user")
    private List<UserAndProductDTO> users;

    public UserAndProductWrapperDTO(List<UserAndProductDTO> users) {
        this.users = users;
        this.usersCount = users.size();
    }
}
