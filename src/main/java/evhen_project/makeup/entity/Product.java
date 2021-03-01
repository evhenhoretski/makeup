package evhen_project.makeup.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
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
