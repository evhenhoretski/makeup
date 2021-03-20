package evhen_project.makeup.service.category.impls;

import evhen_project.makeup.dto.CategoryRequest;
import evhen_project.makeup.dto.CategoryResponse;
import evhen_project.makeup.entity.Category;
import evhen_project.makeup.repository.CategoryRepository;
import evhen_project.makeup.service.category.interfaces.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {
    private final CategoryRepository categoryRepository;
    //private final CategoryMapper mapper;
    @Override
    public List<CategoryResponse> getAll() {
        var categories = categoryRepository.findAll();
        return categories.stream().map(CategoryResponse::mapToCategoryResponse).collect(Collectors.toList());
    }

    @Override
    public CategoryResponse getById(Long id) {
        Optional<Category> result = categoryRepository.findById(id);
        //orElseThrow()
        if (result.isPresent()) {
            return CategoryResponse.mapToCategoryResponse(result.get());
        } else {
            return null;
        }
    }

    //    @Override
//    public Category create(Category category) {
//        return categoryRepository.save(category);
//    }

    public CategoryResponse create(CategoryRequest category) {
        var newCategory  =  Category.builder()
                .id(new Random().nextLong())
                .name(category.getName())
                .description(category.getDescription());
        return null;
                //CategoryResponse.mapToCategoryResponse(categoryRepository.save(newCategory));;
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
