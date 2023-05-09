package softuni.exam.models.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class ImportTownDTO {

    @Size(min = 2)
    private String townName;
    @Min(0)
    private Integer population;

}
