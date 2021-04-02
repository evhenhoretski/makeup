//package evhen_project.makeup.mapper;
//
//import evhen_project.makeup.dto.ProductRequest;
//import evhen_project.makeup.entity.Product;
//import org.springframework.stereotype.Component;
//
//import java.util.Random;
//@Component
//public class ProductMapper {
//    public Product fromRequest(ProductRequest product){
//        return Product.builder()
//                .id(new Random().nextLong())
//                .kind(product.getKind())
//                .sale(product.getSale())
//                .name(product.getName())
//                .build();
//    }
//}
