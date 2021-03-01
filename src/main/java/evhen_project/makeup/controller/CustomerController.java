package evhen_project.makeup.controller;

import evhen_project.makeup.entity.Customer;
import evhen_project.makeup.service.customer.impls.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    CustomerService customerService;

    @GetMapping()
    public List<Customer> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                                 @RequestParam(required = false, defaultValue = "1") Integer page) {
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable Long id) {
        return customerService.getById(id);
    }

    @PostMapping
    public Customer create(@RequestBody Customer customer) {
        return customerService.create(customer);
    }

    @PutMapping("/{id}")
    public Customer update(@PathVariable Long id, @RequestBody Customer customer) {
        return customerService.update(id, customer);
    }

    @DeleteMapping("/{id}")
    public void delete(Long id) {
        customerService.delete(id);
    }
}
