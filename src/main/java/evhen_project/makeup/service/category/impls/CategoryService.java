package evhen_project.makeup.service.category.impls;

import evhen_project.makeup.dto.CategoryResponse;
import evhen_project.makeup.entity.Category;
import evhen_project.makeup.repository.CategoryRepository;
import evhen_project.makeup.service.category.interfaces.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {
    private final CategoryRepository categoryRepository;
    //private final CategoryMapper categoryMapper;
    @Override
    public List<CategoryResponse> getAll() {
        var categories = categoryRepository.findAll();
        return categories.stream().map(CategoryResponse::mapToCategoryResponse).collect(Collectors.toList());
    }

    @Override
    public CategoryResponse getById(Long id) {
        Category result = categoryRepository.findById(id).orElseThrow(NoSuchElementException::new);

            return CategoryResponse.mapToCategoryResponse(result);

    }

    @Override
    public CategoryResponse create(Category category) {
        //var newCategory  =  categoryMapper.fromRequest(category);
        return CategoryResponse.mapToCategoryResponse(categoryRepository.save(category));
    }

    @Override
    public CategoryResponse update(Long id, Category category) {
        return CategoryResponse.mapToCategoryResponse(categoryRepository.save(category));
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
