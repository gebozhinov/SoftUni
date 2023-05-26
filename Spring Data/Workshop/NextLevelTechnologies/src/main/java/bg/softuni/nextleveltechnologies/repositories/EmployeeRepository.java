package bg.softuni.nextleveltechnologies.repositories;

import bg.softuni.nextleveltechnologies.model.enitities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<List<Employee>> findAllByAgeAfter(Integer age);

}
