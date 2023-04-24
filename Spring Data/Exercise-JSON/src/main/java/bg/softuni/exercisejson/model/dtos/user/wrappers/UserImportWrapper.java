package bg.softuni.exercisejson.model.dtos.user.wrappers;

import bg.softuni.exercisejson.model.dtos.user.UserImportDTO;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserImportWrapper {
    @XmlElement(name = "user")
    private List<UserImportDTO> users;
}
