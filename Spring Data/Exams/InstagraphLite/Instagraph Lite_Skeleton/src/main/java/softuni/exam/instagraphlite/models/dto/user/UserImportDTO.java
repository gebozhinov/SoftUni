package softuni.exam.instagraphlite.models.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class UserImportDTO {

    @NotNull
    @Size(min = 2, max = 18)
    private String username;
    @NotNull
    @Size(min = 4)
    private String password;
    @NotNull
    private String profilePicture;
}
