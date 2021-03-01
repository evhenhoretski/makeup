package evhen_project.makeup.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Category {
    @Id
    private Long id;
    private String name;
    private String description;
}
