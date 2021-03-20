//package evhen_project.makeup.services;
//
//import evhen_project.makeup.service.category.impls.CategoryService;
//import evhen_project.makeup.entity.Category;
//import evhen_project.makeup.mapper.CategoryMapper;
//import evhen_project.makeup.repository.CategoryRepository;
//import evhen_project.makeup.stubs.CategoryStub;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.ArgumentCaptor;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.NoSuchElementException;
//import java.util.Optional;
//
//import static evhen_project.makeup.stubs.CategoryStub.*;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.atLeast;
//import static org.mockito.Mockito.when;
//
//@ExtendWith({MockitoExtension.class})
//class CategoryServiceTest {
//    private CategoryService service;
//    @Mock
//    private CategoryRepository categoryRepository;
//    @Mock
//    private CategoryMapper categoryMapper;
//
//    @BeforeEach
//    void setup(){
//        service = new CategoryService(categoryRepository, categoryMapper);
//    }
//
//    @Test
//    void testSuccessfulGetById(){
//        var category = getRandomCategory();
//        when(categoryRepository.findById(any())).thenReturn(Optional.of(category));
//
//        var result = service.getById(ID);
//
//        assertAll(
//                () -> assertEquals(result.getId(), category.getId()),
//                () -> assertEquals(result.getName(), category.getName()),
//                () -> assertEquals(result.getDescription(), category.getDescription()));
//
//    }
//
//    @Test
//    void testNotSuccessfulGetById(){
//        when(categoryRepository.findById(any())).thenReturn(Optional.empty());
//        var e = assertThrows(NoSuchElementException.class, ()->service.getById(ID));
//        assertEquals(e.getMessage(), "No value present");
//    }
//
//    @Test
//    void testSuccessfulSave(){
//        var captor = ArgumentCaptor.forClass(Category.class);
//        var category = getRandomCategory();
//
//        when(categoryMapper.fromRequest(any())).thenReturn(category);
//        when(categoryRepository.save(any())).thenReturn(getRandomCategory());
//        var result = service.create(getCategoryRequset());
//        Mockito.verify(categoryRepository, atLeast(1)).save(captor.capture());
//        assertEquals(category, captor.getValue());
//        assertEquals(category.getName(), result.getName());
//    }
//
//    @Test
//    void testSuccessfulDelete(){
//        service.delete(CategoryStub.ID);
//        var captor = ArgumentCaptor.forClass(Long.class);
//
//        Mockito.verify(categoryRepository, atLeast(1)).deleteById(captor.capture());
//        assertEquals(ID,captor.getValue());
//    }
//
//}