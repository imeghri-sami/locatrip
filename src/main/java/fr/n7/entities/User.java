package fr.n7.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
@Getter @Setter
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String about;
    private Integer userType;
    @Column(unique = true) private String email;
    private String password;
    private Date birthDate;
    private Date created;
}
