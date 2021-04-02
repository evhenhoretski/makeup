package evhen_project.makeup.mapper;

import evhen_project.makeup.dto.CustomerRequest;
import evhen_project.makeup.entity.Customer;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Random;

@Component
public class CustomerMapper {
    public Customer fromRequest(CustomerRequest request){
        return Customer.builder()
                .id(new Random().nextLong())
                .name(request.getName())
                .products(new HashSet<>())
                .build();
    }
}
