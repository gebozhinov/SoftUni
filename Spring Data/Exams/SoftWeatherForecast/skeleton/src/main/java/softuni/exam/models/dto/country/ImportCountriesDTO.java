package softuni.exam.models.dto.country;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Size;

@Getter
@Service
@NoArgsConstructor
public class ImportCountriesDTO {

    @Size(min = 2, max = 60)
    private String countryName;
    @Size(min = 2, max = 20)
    private String currency;

}
