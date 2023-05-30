package fr.n7.resources.dto;

import fr.n7.entities.City;
import fr.n7.entities.Property;
import fr.n7.entities.PropertyImages;
import fr.n7.entities.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class PropertyDTO {
    private Integer id;

    private String name;

    private String description;

    private String address;

    private double price;

    private Date availabilityStartDate;

    private Date availabilityEndDate;

    private int bedroomCount;

    private int bedCount;

    private int guestCount;

    private List<String> images;

    private String type;

    private String currency;

    private User user;

    private City city;

    public PropertyDTO(Property p){
        this.id = p.getId();
        this.address = p.getAddress();
        this.availabilityEndDate = p.getAvailabilityEndDate();
        this.availabilityStartDate = p.getAvailabilityStartDate();
        this.bedCount = p.getBedCount();
        this.bedroomCount = p.getBedroomCount();
        this.guestCount = p.getGuestCount();
        this.name = p.getName();
        this.description = p.getDescription();
        this.price = p.getPrice();
        this.type = p.getType();
        this.currency = p.getCurrency();
        this.user = p.getUser();
        this.city = p.getCity();
        this.images = new ArrayList<>();
        if ( p.getImages() != null )
            for (PropertyImages image : p.getImages())
                images.add(image.getImagePath());

    }
}
