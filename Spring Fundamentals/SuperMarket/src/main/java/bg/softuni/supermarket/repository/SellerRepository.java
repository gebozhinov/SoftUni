package bg.softuni.supermarket.repository;

import bg.softuni.supermarket.domain.entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {

    Optional<Seller> findFirstByFirstNameAndLastName(String firstName, String lastName);
}
