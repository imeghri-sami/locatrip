package fr.n7.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter @Setter
public class PropertyReview {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String comment;

    private int rating;

    private Date added;

    @ManyToOne
    private Property property;

    @ManyToOne
    private User user;
}
