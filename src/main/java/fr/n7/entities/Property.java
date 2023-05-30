package fr.n7.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter
public class Property {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;

    private String address;

    private double price;

    private Date availabilityStartDate;

    private Date availabilityEndDate;

    private int bedroomCount = 0;

    private int bedCount = 0;

    private int guestCount = 0;

    @OneToMany(mappedBy="property")
    private List<PropertyImages> images;

    private String type;

    private String currency;

    @ManyToOne
    private User user;

    @ManyToOne
    private City city;

}
