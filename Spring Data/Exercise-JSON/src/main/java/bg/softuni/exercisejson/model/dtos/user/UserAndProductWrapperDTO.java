package bg.softuni.exercisejson.model.dtos.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserAndProductWrapperDTO {
    private Integer usersCount;
    private List<UserAndProductDTO> users;

    public UserAndProductWrapperDTO(List<UserAndProductDTO> users) {
        this.users = users;
        this.usersCount = users.size();
    }
}
