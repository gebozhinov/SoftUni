package softuni.exam.models.dto.town;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class TownImportDTO {

    @Expose
    @Size(min = 2)
    private String name;
    @Expose
    @Min(0)
    private Integer population;
    @Expose
    private String guide;

}
