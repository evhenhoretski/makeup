package evhen_project.makeup.controller;

import evhen_project.makeup.entity.Information;
import evhen_project.makeup.entity.Product;
import evhen_project.makeup.service.information.impls.InformationService;
import evhen_project.makeup.service.price.impls.PriceService;
import evhen_project.makeup.service.product.impls.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    ProductService productService;

    @GetMapping()
    public List<Product> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                                @RequestParam(required = false, defaultValue = "1") Integer page) {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return productService.create(product);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) {
        return productService.update(id, product);
    }

    @DeleteMapping("/{id}")
    public void delete(Long id) {
        productService.delete(id);
    }

//    @GetMapping("/{categoryId}/products")
//    public List<Product> getProductByCategory(@PathVariable Long categoryId){
//        return null;
//    }
}
