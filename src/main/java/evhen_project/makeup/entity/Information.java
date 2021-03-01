package evhen_project.makeup.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Information {
    @Id
    private Long id;
    private String name;
}
