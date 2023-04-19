package bg.softuni.cardealer.repository;

import bg.softuni.cardealer.model.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT c FROM Customer c " +
            "ORDER BY rand() LIMIT 1")
    Optional<Customer> getRandomCustomer();

    @Query("SELECT c FROM Customer c " +
            "ORDER BY c.birthDate, c.isYoungDriver")
    Optional<List<Customer>> getAllCustomers();


    @Query("SELECT c FROM Customer c " +
            "JOIN c.sales s " +
            "WHERE s.car IS NOT NULL ")
    Optional<List<Customer>> getTotalSalesByCustomer();
}
