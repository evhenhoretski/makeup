package evhen_project.makeup.repository;

import evhen_project.makeup.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Type;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
//    Optional<Category> findCategoryByDescription(String description);
//
//    @Query(value = "SELECT c.id, c.description, c.name, c.products FROM Category as c where c.id = :id ", nativeQuery = true)
//    Optional<Category> findMyCategory(Long id);
    Optional<Type> findTypeByName(String name);
}
