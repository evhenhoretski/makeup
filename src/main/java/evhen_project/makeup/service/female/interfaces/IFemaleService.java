package evhen_project.makeup.service.female.interfaces;

import evhen_project.makeup.entity.Female;

import java.util.List;

public interface IFemaleService {
    List<Female> getAll();
    Female getById(Long id);
    Female create(Female female);
    Female update(Long id, Female female);
    void delete(Long id);
}
