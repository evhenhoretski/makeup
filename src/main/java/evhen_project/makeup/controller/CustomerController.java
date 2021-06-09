package evhen_project.makeup.controller;

import evhen_project.makeup.dto.CustomerRequest;
import evhen_project.makeup.dto.CustomerResponse;
import evhen_project.makeup.entity.Customer;
import evhen_project.makeup.service.customer.impls.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/customer", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {
    public final CustomerService customerService;

    @GetMapping()
    @PreAuthorize("hasAnyRole('ADMIN, USER')")
    public ResponseEntity<List<CustomerResponse>> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                                         @RequestParam(required = false, defaultValue = "1") Integer page) {
        return ResponseEntity.ok(customerService.getAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN, USER')")
    public ResponseEntity<CustomerResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.getById(id));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CustomerResponse> create(@RequestBody CustomerRequest customer) {
        return ResponseEntity.ok(customerService.create(customer));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CustomerResponse> update(@PathVariable Long id, @RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.update(id, customer));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> delete(Long id) {
        customerService.delete(id);
        return ResponseEntity.ok("Successfully deleted");
    }
}
