package evhen_project.makeup.service.product.interfaces;

import evhen_project.makeup.entity.Price;
import evhen_project.makeup.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();
    Product getById(Long id);
    Product create(Product product);
    Product update(Long id, Product product);
    void delete(Long id);

}
