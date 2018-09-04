package kg.edu.iaau.beeline.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Point
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String address;

    private long latitude;

    private long longitude;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;
}
