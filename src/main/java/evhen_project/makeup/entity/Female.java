package evhen_project.makeup.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Entity
public class Female {
    @Id
    private Long id;
    private String name;
    @OneToMany(mappedBy = "female")
    private Set<Product> products;
}
