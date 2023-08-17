package bg.softuni.LinkedOut.repository;

import bg.softuni.LinkedOut.model.dto.AllEmployeesDTO;
import bg.softuni.LinkedOut.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {


    @Query(value = "SELECT first_name as firstName," +
            " last_name as lastName," +
            " job_title as jobTitle," +
            " birthdate " +
            "FROM employees", nativeQuery = true)
    Optional<List<AllEmployeesDTO>> findAllEmployees();

}
