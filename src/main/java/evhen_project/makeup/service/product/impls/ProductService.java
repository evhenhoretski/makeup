package evhen_project.makeup.service.product.impls;

import evhen_project.makeup.dto.ProductRequest;
import evhen_project.makeup.dto.ProductResponse;
import evhen_project.makeup.entity.Product;
import evhen_project.makeup.repository.ProductRepository;
import evhen_project.makeup.service.product.interfaces.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<ProductResponse> getAll() {
        var products = productRepository.findAll();
        return products.stream().map(ProductResponse::mapToProductResponse).collect(Collectors.toList());
    }


    @Override
    public ProductResponse getById(Long id) {
        Optional<Product> result = productRepository.findById(id);
        if (result.isPresent()) {
            return ProductResponse.mapToProductResponse(result.get());
        } else {
            return null;
        }
    }

    @Override
    public ProductResponse create(ProductRequest product) {
        var newProduct  =  Product.builder()
                .id(new Random().nextLong())
                .name(product.getName())
                .sale(product.getSale())
                .kind(product.getKind());
        return null;
                //CustomerResponse.mapToCustomerResponse(productRepository.save(newProduct));
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
