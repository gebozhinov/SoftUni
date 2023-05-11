package com.example.football.models.dto;

import com.example.football.models.entity.enums.Position;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "player")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportPlayerDTO {

    @Size(min = 2)
    @XmlElement(name = "first-name")
    private String firstName;

    @Size(min = 2)
    @XmlElement(name = "last-name")
    private String lastName;

    @Email(regexp = ".+[@].+[\\\\.].+")
    @XmlElement
    private String email;

    @XmlElement(name = "birth-date")
    private String birthdate;

    @XmlElement
    private Position position;

    @XmlElement
    private TownNameWrapper town;

    @XmlElement
    private TeamNameWrapper team;

    @XmlElement
    private StatIdWrapper stat;
}
