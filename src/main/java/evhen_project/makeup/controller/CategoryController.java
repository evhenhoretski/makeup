package evhen_project.makeup.controller;

import evhen_project.makeup.dto.CategoryResponse;
import evhen_project.makeup.entity.Category;
import evhen_project.makeup.service.category.impls.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/categories", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//@Api(value = "Category controller")
public class CategoryController {
    public final CategoryService categoryService;

    @GetMapping()
    @PreAuthorize("hasAnyRole('ADMIN, USER')")
    public ResponseEntity<List<CategoryResponse>> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                                                         @RequestParam(required = false, defaultValue = "1") Integer page){
        return ResponseEntity.ok(categoryService.getAll());
    }

    //@ApiOperation( value = "Get by id", notes = "This method get by id")
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN, USER')")
    //@ApiResponse(code = 200,message = "Successful get by id")
    public ResponseEntity<CategoryResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(categoryService.getById(id));
    }
//            @ApiParam(
//            name = "categoryId",
//            value = "Id of  the needed category",
//            required = true,
//            example = "10")

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CategoryResponse> create(@RequestBody Category category){
        return ResponseEntity.ok(categoryService.create(category));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CategoryResponse> update(@PathVariable Long id, @RequestBody Category category){
        return ResponseEntity.ok(categoryService.update(id, category));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> delete(@PathVariable Long id){
        categoryService.delete(id);
        return ResponseEntity.ok("Successfully deleted");
    }

//    @GetMapping("/{categoryId}/products")
//    public List<Product> getProductByCategory(@PathVariable Long categoryId){
//        return null;
//    }
}
