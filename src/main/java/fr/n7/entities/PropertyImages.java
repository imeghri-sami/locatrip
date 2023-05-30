package fr.n7.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter @Setter
public class PropertyImages {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    private String imagePath;

    @ManyToOne
    private Property property;
}
