package evhen_project.makeup.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity
public class Price {
    @Id
    private Long id;
    private BigDecimal price;
    private String name;

}
