package evhen_project.makeup.controller;

import evhen_project.makeup.entity.Information;
import evhen_project.makeup.service.information.impls.InformationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/information")
public class InformationController {
    InformationService informationService;

    @GetMapping()
    public List<Information> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                                    @RequestParam(required = false, defaultValue = "1") Integer page) {
        return informationService.getAll();
    }

    @GetMapping("/{id}")
    public Information getById(@PathVariable Long id) {
        return informationService.getById(id);
    }

    @PostMapping
    public Information create(@RequestBody Information information) {
        return informationService.create(information);
    }

    @PutMapping("/{id}")
    public Information update(@PathVariable Long id, @RequestBody Information information) {
        return informationService.update(id, information);
    }

    @DeleteMapping("/{id}")
    public void delete(Long id) {
        informationService.delete(id);
    }

//    @GetMapping("/{categoryId}/products")
//    public List<Product> getProductByCategory(@PathVariable Long categoryId){
//        return null;
//    }
}
