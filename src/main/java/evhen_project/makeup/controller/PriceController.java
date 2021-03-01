package evhen_project.makeup.controller;

import evhen_project.makeup.entity.Information;
import evhen_project.makeup.entity.Price;
import evhen_project.makeup.service.information.impls.InformationService;
import evhen_project.makeup.service.price.impls.PriceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/price")
public class PriceController {
    PriceService priceService;

    @GetMapping()
    public List<Price> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                              @RequestParam(required = false, defaultValue = "1") Integer page) {
        return priceService.getAll();
    }

    @GetMapping("/{id}")
    public Price getById(@PathVariable Long id) {
        return priceService.getById(id);
    }

    @PostMapping
    public Price create(@RequestBody Price price) {
        return priceService.create(price);
    }

    @PutMapping("/{id}")
    public Price update(@PathVariable Long id, @RequestBody Price price) {
        return priceService.update(id, price);
    }

    @DeleteMapping("/{id}")
    public void delete(Long id) {
        priceService.delete(id);
    }

//    @GetMapping("/{categoryId}/products")
//    public List<Product> getProductByCategory(@PathVariable Long categoryId){
//        return null;
//    }
}
