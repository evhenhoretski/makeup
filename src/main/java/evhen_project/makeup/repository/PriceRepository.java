package evhen_project.makeup.repository;

import evhen_project.makeup.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Long> {
}
