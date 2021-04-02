package evhen_project.makeup.stubs;

import evhen_project.makeup.dto.CustomerRequest;
import evhen_project.makeup.entity.Customer;

import java.util.HashSet;

public final class CustomerStub {
    public static final Long ID = 1l;
    public static final String NAME = "NAME";
    public static Customer getRandomCustomer(){
        return Customer.builder()
                .id(ID)
                .name(NAME)
                .products(new HashSet<>())
                .build();
    }

    public static CustomerRequest getCustomerRequest(){
        var customerRequest = new CustomerRequest();
        customerRequest.setName(NAME);
        return customerRequest;
    }
}
