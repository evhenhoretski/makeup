package evhen_project.makeup.service.product.interfaces;

import evhen_project.makeup.dto.ProductResponse;
import evhen_project.makeup.entity.Product;

import java.util.List;

public interface IProductService {
    List<ProductResponse> getAll();
    ProductResponse getById(Long id);
    //ProductResponse create(ProductRequest product);
    ProductResponse create(Product product);
    ProductResponse update(Long id, Product product);
    void delete(Long id);

}
