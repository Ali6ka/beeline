package kg.edu.iaau.beeline.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@Data
public class Company
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private  String website;

    @OneToMany(
            mappedBy = "company",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Point> points;
}
