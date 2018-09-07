package kg.edu.iaau.beeline.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
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

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getFullname()
    {
        return fullname;
    }

    public void setFullname(String fullname)
    {
        this.fullname = fullname;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public boolean getIsAdmin()
    {
        return isAdmin;
    }

    public void setIsAdmin(boolean admin)
    {
        isAdmin = admin;
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
