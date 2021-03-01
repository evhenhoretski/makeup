package evhen_project.makeup.repository;

import evhen_project.makeup.entity.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {
}
