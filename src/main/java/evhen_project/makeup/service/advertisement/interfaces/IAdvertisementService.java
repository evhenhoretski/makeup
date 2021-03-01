package evhen_project.makeup.service.advertisement.interfaces;

import evhen_project.makeup.entity.Advertisement;
import evhen_project.makeup.entity.Category;

import java.util.List;

public interface IAdvertisementService {
    List<Advertisement> getAll();
    Advertisement getById(Long id);
    Advertisement create(Advertisement advertisement);
    Advertisement update(Long id, Advertisement advertisement);
    void delete(Long id);

}
