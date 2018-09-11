package kg.edu.iaau.core.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
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

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getWebsite()
    {
        return website;
    }

    public void setWebsite(String website)
    {
        this.website = website;
    }

    public Set<Point> getPoints()
    {
        return points;
    }

    public void setPoints(Set<Point> points)
    {
        this.points = points;
    }
}
