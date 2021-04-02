package evhen_project.makeup.services;

import evhen_project.makeup.entity.Category;
import evhen_project.makeup.repository.CategoryRepository;
import evhen_project.makeup.service.category.impls.CategoryService;
import evhen_project.makeup.stubs.CategoryStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static evhen_project.makeup.stubs.CategoryStub.ID;
import static evhen_project.makeup.stubs.CategoryStub.getRandomCategory;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
class CategoryServiceTest {
    private CategoryService service;
    @Mock
    private CategoryRepository categoryRepository;
    //@Mock
    //private CategoryMapper categoryMapper;

    @BeforeEach
    void setup(){
        service = new CategoryService(categoryRepository);
    }

    @Test
    void getSuccessful() {
        List<Category> list = new ArrayList<Category>();
        var category = getRandomCategory();
        list.add(category);
        list.add(category);
        list.add(category);

        when(categoryRepository.findAll()).thenReturn(list);
        var getAll = service.getAll();
        assertEquals(list.size(), getAll.size());
    }

    @Test
    void testSuccessfulGetById(){
        var category = CategoryStub.getRandomCategory();
        when(categoryRepository.findById(any())).thenReturn(Optional.of(category));
        var result = service.getById(CategoryStub.ID);

        assertAll(
                () -> assertEquals(result.getId(), category.getId()),
                () -> assertEquals(result.getName(), category.getName()),
                () -> assertEquals(result.getDescription(), category.getDescription()));

    }

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

    @Test
    void getFailedById() {
        when(categoryRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        assertThrows(NoSuchElementException.class, () -> service.getById(CategoryStub.ID));
    }

    @Test
    void createSuccessful() {
        var captor = ArgumentCaptor.forClass(Category.class);
        var category = CategoryStub.getRandomCategory();
        //when(categoryMapper.fromRequest(any())).thenReturn(category);
        when(categoryRepository.save(any())).thenReturn(CategoryStub.getRandomCategory());
        var result = service.create(CategoryStub.getRandomCategory());
        Mockito.verify(categoryRepository, atLeast(1)).save(captor.capture());
        assertEquals(category, captor.getValue());
        assertEquals(category.getName(), result.getName());
        assertEquals(category.getId(), result.getId());
        assertEquals(category.getDescription(), result.getDescription());
    }

    @Test
    void updateSuccessful() {
        var captor = ArgumentCaptor.forClass(Category.class);
        var category = CategoryStub.getRandomCategory();
        when(categoryRepository.save(any())).thenReturn(CategoryStub.getRandomCategory());
        var result = service.update(CategoryStub.ID, CategoryStub.getRandomCategory());
        Mockito.verify(categoryRepository, atLeast(1)).save(captor.capture());
        assertEquals(category, captor.getValue());
        assertEquals(category.getName(), result.getName());
        assertEquals(category.getDescription(), result.getDescription());
        assertEquals(category.getId(), result.getId());
    }

    @Test
    void testSuccessfulDelete(){
        service.delete(ID);
        var captor = ArgumentCaptor.forClass(Long.class);
        Mockito.verify(categoryRepository, atLeast(1)).deleteById(captor.capture());
        assertEquals(ID,captor.getValue());
    }

}