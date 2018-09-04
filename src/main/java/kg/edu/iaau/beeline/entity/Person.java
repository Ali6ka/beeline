package kg.edu.iaau.beeline.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@Data
public class Person
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    private String password;

    private String fullname;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "is_admin")
    private boolean isAdmin;

    @OneToMany(
            mappedBy = "person",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Point> points;
}
