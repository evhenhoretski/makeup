package evhen_project.makeup.services;

import evhen_project.makeup.entity.Customer;
import evhen_project.makeup.mapper.CustomerMapper;
import evhen_project.makeup.repository.CustomerRepository;
import evhen_project.makeup.service.customer.impls.CustomerService;
import evhen_project.makeup.stubs.CategoryStub;
import evhen_project.makeup.stubs.CustomerStub;
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
import static evhen_project.makeup.stubs.CustomerStub.getRandomCustomer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
class CustomerServiceTest {
    private CustomerService service;
    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private CustomerMapper customerMapper;

    @BeforeEach
    void setup(){
        service = new CustomerService(customerRepository, customerMapper);
    }

    @Test
    void getSuccessful() {
        List<Customer> list = new ArrayList<Customer>();
        var customer = getRandomCustomer();
        list.add(customer);
        list.add(customer);
        list.add(customer);

        when(customerRepository.findAll()).thenReturn(list);
        var getAll = service.getAll();
        assertEquals(list.size(), getAll.size());
    }

    @Test
    void testSuccessfulGetById(){
        var category = CustomerStub.getRandomCustomer();
        when(customerRepository.findById(any())).thenReturn(Optional.of(category));
        var result = service.getById(CategoryStub.ID);

        assertAll(
                () -> assertEquals(result.getId(), category.getId()),
                () -> assertEquals(result.getName(), category.getName()));

    }

    @Test
    void getFailedById() {
        when(customerRepository.findById(any())).thenReturn(Optional.empty());
        assertThrows(NoSuchElementException.class, () -> service.getById(CustomerStub.ID));
        //assertEquals(e.getMessage(), "No value present");
    }

    @Test
    void createSuccessful() {
        var captor = ArgumentCaptor.forClass(Customer.class);
        var customer = CustomerStub.getRandomCustomer();
        when(customerMapper.fromRequest(any())).thenReturn(customer);
        when(customerRepository.save(any())).thenReturn(CustomerStub.getRandomCustomer());
        var result = service.create(CustomerStub.getCustomerRequest());
        Mockito.verify(customerRepository, atLeast(1)).save(captor.capture());
        assertEquals(customer, captor.getValue());
        assertEquals(customer.getName(), result.getName());
        assertEquals(customer.getId(), result.getId());
    }

    @Test
    void updateSuccessful() {
        var captor = ArgumentCaptor.forClass(Customer.class);
        var customer = CustomerStub.getRandomCustomer();
        when(customerRepository.save(any())).thenReturn(CustomerStub.getRandomCustomer());
        var result = service.update(CustomerStub.ID, CustomerStub.getRandomCustomer());
        Mockito.verify(customerRepository, atLeast(1)).save(captor.capture());
        assertEquals(customer, captor.getValue());
        assertEquals(customer.getName(), result.getName());
        assertEquals(customer.getId(), result.getId());
    }

    @Test
    void testSuccessfulDelete(){
        service.delete(ID);
        var captor = ArgumentCaptor.forClass(Long.class);
        Mockito.verify(customerRepository, atLeast(1)).deleteById(captor.capture());
        assertEquals(ID,captor.getValue());
    }

}
