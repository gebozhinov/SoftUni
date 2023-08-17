package bg.softuni.LinkedOut.model.dto;

import java.time.LocalDate;

public interface AllEmployeesDTO {

    String getFirstName();
    String getLastName();
    String getJobTitle();
    LocalDate getBirthdate();

}
