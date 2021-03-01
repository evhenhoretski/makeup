package evhen_project.makeup.controller;

import evhen_project.makeup.entity.Sales;
import evhen_project.makeup.service.sales.impls.SalesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SalesController {
    SalesService salesService;

    @GetMapping()
    public List<Sales> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                              @RequestParam(required = false, defaultValue = "1") Integer page) {
        return salesService.getAll();
    }

    @GetMapping("/{id}")
    public Sales getById(@PathVariable Long id) {
        return salesService.getById(id);
    }

    @PostMapping
    public Sales create(@RequestBody Sales sales) {
        return salesService.create(sales);
    }

    @PutMapping("/{id}")
    public Sales update(@PathVariable Long id, @RequestBody Sales sales) {
        return salesService.update(id, sales);
    }

    @DeleteMapping("/{id}")
    public void delete(Long id) {
        salesService.delete(id);
    }

//    @GetMapping("/{categoryId}/products")
//    public List<Product> getProductByCategory(@PathVariable Long categoryId){
//        return null;
//    }
}
