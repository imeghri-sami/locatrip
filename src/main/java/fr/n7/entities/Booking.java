package fr.n7.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date checkInDate;
    private Date checkOutDate;
    private Date bookingDate;

    @ManyToOne
    private Property property;

    @ManyToOne
    private User user;
}
