package evhen_project.makeup.services;

import evhen_project.makeup.entity.Product;
import evhen_project.makeup.repository.ProductRepository;
import evhen_project.makeup.service.product.impls.ProductService;
import evhen_project.makeup.stubs.ProductStub;
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
import static evhen_project.makeup.stubs.ProductStub.getRandomProduct;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
public class ProductServiceTest {
    private ProductService service;
    @Mock
    private ProductRepository productRepository;
    //@Mock
    //private CategoryMapper categoryMapper;

    @BeforeEach
    void setup(){
        service = new ProductService(productRepository);
    }

    @Test
    void getSuccessful() {
        List<Product> list = new ArrayList<Product>();
        var product = getRandomProduct();
        list.add(product);
        list.add(product);
        list.add(product);

        when(productRepository.findAll()).thenReturn(list);
        var getAll = service.getAll();
        assertEquals(list.size(), getAll.size());
    }

    @Test
    void testSuccessfulGetById(){
        var product = ProductStub.getRandomProduct();
        when(productRepository.findById(any())).thenReturn(Optional.of(product));
        var result = service.getById(ProductStub.ID);

        assertAll(
                () -> assertEquals(result.getId(), product.getId()),
                () -> assertEquals(result.getName(), product.getName()),
                () -> assertEquals(result.getSale(), product.getSale()),
                () -> assertEquals(result.getKind(), product.getKind()));

    }

    @Test
    void getFailedById() {
        when(productRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        assertThrows(NoSuchElementException.class, () -> service.getById(ProductStub.ID));
    }

    @Test
    void createSuccessful() {
        var captor = ArgumentCaptor.forClass(Product.class);
        var product = ProductStub.getRandomProduct();
        //when(categoryMapper.fromRequest(any())).thenReturn(category);
        when(productRepository.save(any())).thenReturn(ProductStub.getRandomProduct());
        var result = service.create(ProductStub.getRandomProduct());
        Mockito.verify(productRepository, atLeast(1)).save(captor.capture());
        assertEquals(product, captor.getValue());
        assertEquals(product.getName(), result.getName());
        assertEquals(product.getId(), result.getId());
        assertEquals(product.getKind(), result.getKind());
        assertEquals(product.getSale(), result.getSale());
    }

    @Test
    void updateSuccessful() {
        var captor = ArgumentCaptor.forClass(Product.class);
        var product = ProductStub.getRandomProduct();
        when(productRepository.save(any())).thenReturn(ProductStub.getRandomProduct());
        var result = service.update(ProductStub.ID, ProductStub.getRandomProduct());
        Mockito.verify(productRepository, atLeast(1)).save(captor.capture());
        assertEquals(product, captor.getValue());
        assertEquals(product.getName(), result.getName());
        assertEquals(product.getKind(), result.getKind());
        assertEquals(product.getSale(), result.getSale());
        assertEquals(product.getId(), result.getId());
    }

    @Test
    void testSuccessfulDelete(){
        service.delete(ID);
        var captor = ArgumentCaptor.forClass(Long.class);
        Mockito.verify(productRepository, atLeast(1)).deleteById(captor.capture());
        assertEquals(ID,captor.getValue());
    }
}
