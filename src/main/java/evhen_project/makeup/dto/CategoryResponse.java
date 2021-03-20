package evhen_project.makeup.dto;

import evhen_project.makeup.entity.Category;
import lombok.Data;

@Data
public class CategoryResponse {
    private Long id;
    private String name;
    private String description;

    public static CategoryResponse mapToCategoryResponse(Category category) {
        CategoryResponse categoryResponse = new CategoryResponse();

        categoryResponse.setId(category.getId());
        categoryResponse.setDescription(category.getDescription());
        categoryResponse.setName(category.getName());

        return categoryResponse;
    }
}
