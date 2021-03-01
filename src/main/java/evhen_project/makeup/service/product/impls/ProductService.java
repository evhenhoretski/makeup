package evhen_project.makeup.service.product.impls;

import evhen_project.makeup.entity.Product;
import evhen_project.makeup.repository.ProductRepository;
import evhen_project.makeup.service.product.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }


    @Override
    public Product getById(Long id) {
        Optional<Product> result = productRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Long id, Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
