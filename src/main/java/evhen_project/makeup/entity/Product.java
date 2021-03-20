package evhen_project.makeup.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    private Long id;
    private String name;
    private String kind;
    private String sale;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
