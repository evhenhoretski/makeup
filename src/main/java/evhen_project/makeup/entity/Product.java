package evhen_project.makeup.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Product {
    @Id
    private Long id;
    private String name;
    private String kind;
    private String sale;
    @ManyToOne
    @JoinColumn(name = "price_id")
    private Price price;
    @ManyToOne
    @JoinColumn(name = "sales_id")
    private Sales sales;
    @ManyToOne
    @JoinColumn(name = "female_id")
    private Female female;
    @ManyToOne
    @JoinColumn(name = "male_id")
    private Male male;
}
