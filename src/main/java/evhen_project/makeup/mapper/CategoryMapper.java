//package evhen_project.makeup.mapper;
//
//import evhen_project.makeup.dto.CategoryRequest;
//import evhen_project.makeup.entity.Category;
//import org.springframework.stereotype.Component;
//
//import java.util.Random;
//
//@Component
//public class CategoryMapper {
//
//    public Category fromRequest(CategoryRequest category){
//        return Category.builder()
//                .id(new Random().nextLong())
//                .description(category.getDescription())
//                .name(category.getName()).build();
//    }
//}
