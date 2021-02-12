package evhen_project.makeup.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Entity
public class Product {
    @Id
    private Long id;
    private String name;
    private String kind;
    private String female;
    private String male;
    @OneToMany(mappedBy = "product")
    private Set<Person> person;
}
