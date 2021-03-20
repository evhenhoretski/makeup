package evhen_project.makeup.service.customer.interfaces;

import evhen_project.makeup.dto.CustomerRequest;
import evhen_project.makeup.dto.CustomerResponse;
import evhen_project.makeup.entity.Customer;

import java.util.List;

public interface ICustomerService {
    List<CustomerResponse> getAll();
    CustomerResponse getById(Long id);
    CustomerResponse create(CustomerRequest customer);
    CustomerResponse update(Long id, Customer customer);
    void delete(Long id);
}
