package evhen_project.makeup.service.information.interfaces;

import evhen_project.makeup.entity.Category;
import evhen_project.makeup.entity.Information;

import java.util.List;

public interface IInformationService {
    List<Information> getAll();
    Information getById(Long id);
    Information create(Information information);
    Information update(Long id, Information information);
    void delete(Long id);

}
