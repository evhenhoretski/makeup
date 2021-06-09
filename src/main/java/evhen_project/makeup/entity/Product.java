package evhen_project.makeup.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
//    private BigDecimal price;
//    private Currency currency;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
