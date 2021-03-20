package evhen_project.makeup.dto;

import evhen_project.makeup.entity.Customer;
import lombok.Data;

@Data
public class CustomerResponse {
    private Long id;
    private String name;

    public static CustomerResponse mapToCustomerResponse(Customer customer) {
        CustomerResponse customerResponse = new CustomerResponse();

        customerResponse.setId(customer.getId());
        customerResponse.setName(customer.getName());

        return customerResponse;
    }
}