package evhen_project.makeup.controller;

import evhen_project.makeup.dto.CategoryResponse;
import evhen_project.makeup.entity.Category;
import evhen_project.makeup.service.category.impls.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
//@Api(value = "Category controller")
public class CategoryController {
    public final CategoryService categoryService;

    @GetMapping()
    public List<CategoryResponse> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                                         @RequestParam(required = false, defaultValue = "1") Integer page){
        return categoryService.getAll();
    }

    //@ApiOperation( value = "Get by id", notes = "This method get by id")
    @GetMapping("/{id}")
    //@ApiResponse(code = 200,message = "Successful get by id")
    public CategoryResponse getById(@PathVariable Long id){
        return categoryService.getById(id);
    }
//            @ApiParam(
//            name = "categoryId",
//            value = "Id of  the needed category",
//            required = true,
//            example = "10")

    @PostMapping
    public CategoryResponse create(@RequestBody Category category){
        return categoryService.create(category);
    }

    @PutMapping("/{id}")
    public CategoryResponse update(@PathVariable Long id, @RequestBody Category category){
        return categoryService.update(id, category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        categoryService.delete(id);
    }

//    @GetMapping("/{categoryId}/products")
//    public List<Product> getProductByCategory(@PathVariable Long categoryId){
//        return null;
//    }
}
