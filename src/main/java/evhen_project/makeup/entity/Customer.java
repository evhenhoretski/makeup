package evhen_project.makeup.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    private Long id;
    private String name;
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "customer")
    private Set<Product> products;
}
