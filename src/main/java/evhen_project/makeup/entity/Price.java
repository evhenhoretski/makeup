package evhen_project.makeup.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Data
@Entity
public class Price {
    @Id
    private Long id;
    private BigDecimal price;
    private String name;
    @OneToMany(mappedBy = "price")
    private Set<Product> products;
}
