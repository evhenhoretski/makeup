package evhen_project.makeup.service.product.impls;

import evhen_project.makeup.dto.ProductResponse;
import evhen_project.makeup.entity.Product;
import evhen_project.makeup.repository.ProductRepository;
import evhen_project.makeup.service.product.interfaces.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {
    private final ProductRepository productRepository;
    @Override
    public List<ProductResponse> getAll() {
        var products = productRepository.findAll();
        return products.stream().map(ProductResponse::mapToProductResponse).collect(Collectors.toList());
    }


    @Override
    public ProductResponse getById(Long id) {
        Product result = productRepository.findById(id).orElseThrow(NoSuchElementException::new);

        return ProductResponse.mapToProductResponse(result);
    }

    @Override
    public ProductResponse create(Product product) {

        return ProductResponse.mapToProductResponse(productRepository.save(product));
    }

    @Override
    public ProductResponse update(Long id, Product product) {
        return ProductResponse.mapToProductResponse(productRepository.save(product));
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
