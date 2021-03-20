package evhen_project.makeup.repository;

import evhen_project.makeup.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
//    Optional<Category> findCategoriesByDescriptionOOrderByName(String description);
//    //List<Category> findAllByProductIn(Set<Product> products);
//    @Query(value = "SELECT c.id, c.description, c.name from Category as c where c.id = :id", nativeQuery = true)
//    Optional<Category> findMyCategory(Long id);
}
