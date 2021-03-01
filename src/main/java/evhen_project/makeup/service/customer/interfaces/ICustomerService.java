package evhen_project.makeup.service.customer.interfaces;

import evhen_project.makeup.entity.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getAll();
    Customer getById(Long id);
    Customer create(Customer customer);
    Customer update(Long id, Customer customer);
    void delete(Long id);
}
