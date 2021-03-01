package evhen_project.makeup.repository;

import evhen_project.makeup.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
