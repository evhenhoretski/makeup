package evhen_project.makeup.controller;

import evhen_project.makeup.entity.Female;
import evhen_project.makeup.service.female.impls.FemaleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/female")
public class FemaleController {
    FemaleService femaleService;

    @GetMapping()
    public List<Female> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                               @RequestParam(required = false, defaultValue = "1") Integer page){
        return femaleService.getAll();
    }

    @GetMapping("/{id}")
    public Female getById(@PathVariable Long id){
        return femaleService.getById(id);
    }

    @PostMapping
    public Female create(@RequestBody Female female){
        return femaleService.create(female);
    }

    @PutMapping("/{id}")
    public Female update(@PathVariable Long id, @RequestBody Female female){
        return femaleService.update(id, female);
    }

    @DeleteMapping("/{id}")
    public void delete(Long id){
        femaleService.delete(id);
    }

//    @GetMapping("/{categoryId}/products")
//    public List<Product> getProductByCategory(@PathVariable Long categoryId){
//        return null;
//    }
}
