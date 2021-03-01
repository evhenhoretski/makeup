package evhen_project.makeup.controller;

import evhen_project.makeup.entity.Category;
import evhen_project.makeup.service.category.impls.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    CategoryService categoryService;

    @GetMapping()
    public List<Category> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                                 @RequestParam(required = false, defaultValue = "1") Integer page){
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable Long id){
        return categoryService.getById(id);
    }

    @PostMapping
    public Category create(@RequestBody Category category){
        return categoryService.create(category);
    }

    @PutMapping("/{id}")
    public Category update(@PathVariable Long id, @RequestBody Category category){
        return categoryService.update(id, category);
    }

    @DeleteMapping("/{id}")
    public void delete(Long id){
        categoryService.delete(id);
    }

//    @GetMapping("/{categoryId}/products")
//    public List<Product> getProductByCategory(@PathVariable Long categoryId){
//        return null;
//    }
}
