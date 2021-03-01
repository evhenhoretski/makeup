package evhen_project.makeup.service.price.interfaces;

import evhen_project.makeup.entity.Category;
import evhen_project.makeup.entity.Price;

import java.util.List;

public interface IPriceService {
    List<Price> getAll();
    Price getById(Long id);
    Price create(Price price);
    Price update(Long id, Price price);
    void delete(Long id);

}
