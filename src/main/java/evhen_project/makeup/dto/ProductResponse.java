package evhen_project.makeup.dto;

import evhen_project.makeup.entity.Product;
import lombok.Data;

@Data
public class ProductResponse {
    private Long id;
    private String name;
    private String kind;
    private String sale;

    public static ProductResponse mapToProductResponse(Product product) {
        ProductResponse productResponse = new ProductResponse();

        productResponse.setId(product.getId());
        productResponse.setKind(product.getKind());
        productResponse.setName(product.getName());
        productResponse.setSale(product.getSale());

        return productResponse;
    }
}
