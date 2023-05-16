package softuni.exam.instagraphlite.models.dto.picture;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class PictureImportDTO {

    @NotNull
    private String path;
    @NotNull
    @DecimalMin(value = "500")
    @DecimalMax(value = "60000")
    private Double size;

}
