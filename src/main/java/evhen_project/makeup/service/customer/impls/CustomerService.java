package evhen_project.makeup.service.customer.impls;

import evhen_project.makeup.entity.Customer;
import evhen_project.makeup.repository.CustomerRepository;
import evhen_project.makeup.service.customer.interfaces.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CustomerService implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }


    @Override
    public Customer getById(Long id) {
        Optional<Customer> result = customerRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(Long id, Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
}
