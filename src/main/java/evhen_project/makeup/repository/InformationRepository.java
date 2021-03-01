package evhen_project.makeup.repository;

import evhen_project.makeup.entity.Information;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformationRepository extends JpaRepository<Information, Long> {
}
