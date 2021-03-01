package evhen_project.makeup.service.male.interfaces;

import evhen_project.makeup.entity.Male;

import java.util.List;

public interface IMaleService {
    List<Male> getAll();
    Male getById(Long id);
    Male create(Male male);
    Male update(Long id, Male male);
    void delete(Long id);

}
