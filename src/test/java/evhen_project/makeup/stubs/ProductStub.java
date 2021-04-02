package evhen_project.makeup.stubs;

import evhen_project.makeup.entity.Product;

public final class ProductStub {
    public static final Long ID = 1l;
    public static final String NAME = "NAME";
    public static final String KIND = "KIND";
    public static final String SALE = "SALE";
    public static Product getRandomProduct(){
        return Product.builder()
                .id(ID)
                .name(NAME)
                .kind(KIND)
                .sale(SALE)
                .build();
    }

//    public static ProductRequest getProductRequset(){
//        var productRequest = new ProductRequest();
//        productRequest.setName(NAME);
//        productRequest.setKind(KIND);
//        productRequest.setKind(SALE);
//        return productRequest;
//    }
}
