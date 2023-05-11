package com.example.football.models.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "stat")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportStatDTO {

    @DecimalMin("0")
    private Float shooting;
    @DecimalMin("0")
    private Float passing;
    @DecimalMin("0")
    private Float endurance;

}
