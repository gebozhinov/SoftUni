package bg.softuni.LinkedOut.repository;

import bg.softuni.LinkedOut.model.dto.AllCompaniesDTO;
import bg.softuni.LinkedOut.model.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CompanyRepository extends JpaRepository<Company, UUID> {

    @Query(value = "SELECT * FROM companies " +
            "WHERE name = :name",nativeQuery = true)
    Optional<Company> findByName(String name);

    @Query(value = "SELECT name FROM companies",nativeQuery = true)
    Optional<List<String>> findAllCompanyNames();

    @Query(value = "SELECT name," +
            " town," +
            " concat(left(description, 5), '...')" +
            " as description from companies",nativeQuery = true)
    Optional<List<AllCompaniesDTO>> findAllCompanies();
}
