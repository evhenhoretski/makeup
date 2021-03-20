package evhen_project.makeup.service.category.interfaces;

import evhen_project.makeup.dto.CategoryRequest;
import evhen_project.makeup.dto.CategoryResponse;
import evhen_project.makeup.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<CategoryResponse> getAll();
    CategoryResponse getById(Long id);
    CategoryResponse create(CategoryRequest category);
    CategoryResponse update(Long id, Category category);
    void delete(Long id);

}
