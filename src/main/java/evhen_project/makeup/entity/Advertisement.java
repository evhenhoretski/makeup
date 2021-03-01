package evhen_project.makeup.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Advertisement {
    @Id
    private Long id;
    private String name;
}
