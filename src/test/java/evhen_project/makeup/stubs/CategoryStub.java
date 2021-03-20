//package evhen_project.makeup.stubs;
//
//import evhen_project.makeup.dto.CategoryRequest;
//import evhen_project.makeup.entity.Category;
//
//public final class CategoryStub {
//    public static final Long ID = 1l;
//    public static final String NAME = "NAME";
//    public static final String DESCRIPTION = "DESCRIPTION";
//    public static Category.CategoryBuilder getRandomCategory(){
//        return Category.builder()
//                        .id(ID)
//                        .name(NAME)
//                        .description(DESCRIPTION)
//                        .build();
//    }
//
//    public static CategoryRequest getCategoryRequset(){
//        var categoryRequest = new CategoryRequest();
//        categoryRequest.setName(NAME);
//        categoryRequest.setDescription(DESCRIPTION);
//        return categoryRequest;
//    }
//}
