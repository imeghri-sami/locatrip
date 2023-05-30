package fr.n7.resources.dto;

import fr.n7.entities.Property;
import fr.n7.entities.PropertyReview;
import fr.n7.entities.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.ManyToOne;
import java.util.Date;

@Getter
@Setter
public class PropertyReviewDTO {
    private Integer id;
    private String comment;

    private int rating;

    private Date added;

    private User user;

    public PropertyReviewDTO (PropertyReview propertyReview){
        this.id = propertyReview.getId();
        this.comment = propertyReview.getComment();
        this.rating = propertyReview.getRating();
        this.added = propertyReview.getAdded();
        this.user = propertyReview.getUser();
    }

}
