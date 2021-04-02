package evhen_project.makeup.service.customer.impls;

import evhen_project.makeup.dto.CustomerRequest;
import evhen_project.makeup.dto.CustomerResponse;
import evhen_project.makeup.entity.Customer;
import evhen_project.makeup.mapper.CustomerMapper;
import evhen_project.makeup.repository.CustomerRepository;
import evhen_project.makeup.service.customer.interfaces.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    @Override
    public List<CustomerResponse> getAll() {
        var customers = customerRepository.findAll();
        return customers.stream().map(CustomerResponse::mapToCustomerResponse).collect(Collectors.toList());
    }


    @Override
    public CustomerResponse getById(Long id) {
        Customer result = customerRepository.findById(id).orElseThrow(NoSuchElementException::new);

            return CustomerResponse.mapToCustomerResponse(result);

    }

    @Override
    public CustomerResponse create(CustomerRequest customer) {
        var newCustomer  =  customerMapper.fromRequest(customer);
        return CustomerResponse.mapToCustomerResponse(customerRepository.save(newCustomer   ));
    }

    @Override
    public CustomerResponse update(Long id, Customer customer) {
        return CustomerResponse.mapToCustomerResponse(customerRepository.save(customer));
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
}
