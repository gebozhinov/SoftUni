package bg.softuni.exercisespringdataadvancedquerying.repository;

import bg.softuni.exercisespringdataadvancedquerying.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
