package evhen_project.makeup.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Person {
    @Id
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
