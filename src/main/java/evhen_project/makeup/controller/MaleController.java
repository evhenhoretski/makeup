package evhen_project.makeup.controller;

import evhen_project.makeup.entity.Male;
import evhen_project.makeup.service.male.impls.MaleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/male")
public class MaleController {
    MaleService maleService;

    @GetMapping()
    public List<Male> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                             @RequestParam(required = false, defaultValue = "1") Integer page) {
        return maleService.getAll();
    }

    @GetMapping("/{id}")
    public Male getById(@PathVariable Long id) {
        return maleService.getById(id);
    }

    @PostMapping
    public Male create(@RequestBody Male male) {
        return maleService.create(male);
    }

    @PutMapping("/{id}")
    public Male update(@PathVariable Long id, @RequestBody Male male) {
        return maleService.update(id, male);
    }

    @DeleteMapping("/{id}")
    public void delete(Long id) {
        maleService.delete(id);
    }

//    @GetMapping("/{categoryId}/products")
//    public List<Product> getProductByCategory(@PathVariable Long categoryId){
//        return null;
//    }
}
