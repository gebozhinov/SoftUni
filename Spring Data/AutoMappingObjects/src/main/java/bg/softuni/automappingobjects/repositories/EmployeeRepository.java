package bg.softuni.automappingobjects.repositories;

import bg.softuni.automappingobjects.entities.Employee;
import bg.softuni.automappingobjects.entities.dto.Employee3DTO;
import bg.softuni.automappingobjects.entities.dto.EmployeeFirstNameAndSalary;
import bg.softuni.automappingobjects.entities.dto.EmployeeNameDTO;
import bg.softuni.automappingobjects.entities.dto.ManagerDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT NEW bg.softuni.automappingobjects.entities.dto.EmployeeNameDTO(e.firstName, e.lastName) " +
            "FROM Employee e " +
            "WHERE e.id = :id")
    Optional<EmployeeNameDTO> findNamesById(long id);

    Optional<EmployeeFirstNameAndSalary> findFirstNameAndSalaryById(long id);

    @Query("SELECT e " +
            "FROM Employee e " +
            "WHERE YEAR(e.birthday) < '1990' " +
            "ORDER BY e.salary DESC ")
    List<Employee> getInfo();
}
