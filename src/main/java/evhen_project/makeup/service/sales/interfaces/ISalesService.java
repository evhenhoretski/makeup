package evhen_project.makeup.service.sales.interfaces;

import evhen_project.makeup.entity.Category;
import evhen_project.makeup.entity.Sales;

import java.util.List;

public interface ISalesService {
    List<Sales> getAll();
    Sales getById(Long id);
    Sales create(Sales sales);
    Sales update(Long id, Sales sales);
    void delete(Long id);

}
