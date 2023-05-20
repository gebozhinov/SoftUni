package softuni.exam.models.dto.passenger;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class PassengerImportDTO {

    @Expose
    @Size(min = 2)
    private String firstName;
    @Expose
    @Size(min = 2)
    private String lastName;
    @Expose
    @Min(0)
    private Integer age;
    @Expose
    private String phoneNumber;
    @Expose
    @Email(regexp = ".+[@].+[\\\\.].+")
    private String email;
    @Expose
    private String town;

}
