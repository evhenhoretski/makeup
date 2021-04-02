package evhen_project.makeup.controller;

import evhen_project.makeup.dto.CustomerRequest;
import evhen_project.makeup.dto.CustomerResponse;
import evhen_project.makeup.entity.Customer;
import evhen_project.makeup.service.customer.impls.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {
    public final CustomerService customerService;

    @GetMapping()
    public List<CustomerResponse> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                                         @RequestParam(required = false, defaultValue = "1") Integer page) {
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    public CustomerResponse getById(@PathVariable Long id) {
        return customerService.getById(id);
    }

    @PostMapping
    public CustomerResponse create(@RequestBody CustomerRequest customer) {
        return customerService.create(customer);
    }

    @PutMapping("/{id}")
    public CustomerResponse update(@PathVariable Long id, @RequestBody Customer customer) {
        return customerService.update(id, customer);
    }

    @DeleteMapping("/{id}")
    public void delete(Long id) {
        customerService.delete(id);
    }
}
