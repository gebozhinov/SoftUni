package com.example.football.models.dto;

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
    private String name;

    @Min(1)
    private Integer population;

    @Size(min = 10)
    private String travelGuide;

}
