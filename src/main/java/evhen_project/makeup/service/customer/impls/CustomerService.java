package evhen_project.makeup.service.customer.impls;

import evhen_project.makeup.dto.CustomerRequest;
import evhen_project.makeup.dto.CustomerResponse;
import evhen_project.makeup.entity.Customer;
import evhen_project.makeup.repository.CustomerRepository;
import evhen_project.makeup.service.customer.interfaces.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<CustomerResponse> getAll() {
        var customers = customerRepository.findAll();
        return customers.stream().map(CustomerResponse::mapToCustomerResponse).collect(Collectors.toList());
    }


    @Override
    public CustomerResponse getById(Long id) {
        Optional<Customer> result = customerRepository.findById(id);
        if (result.isPresent()) {
            return CustomerResponse.mapToCustomerResponse(result.get());
        } else {
            return null;
        }
    }

    @Override
    public CustomerResponse create(CustomerRequest customer) {
        var newCustomer  =  Customer.builder()
                .id(new Random().nextLong())
                .name(customer.getName())
                .products(new HashSet<>());
        return null;
                //CustomerResponse.mapToCustomerResponse(customerRepository.save(newCustomer));;
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
