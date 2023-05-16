package fr.n7.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Property {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getAvailabilityStartDate() {
        return availabilityStartDate;
    }

    public void setAvailabilityStartDate(Date availabilityStartDate) {
        this.availabilityStartDate = availabilityStartDate;
    }

    public Date getAvailabilityEndDate() {
        return availabilityEndDate;
    }

    public void setAvailabilityEndDate(Date availabilityEndDate) {
        this.availabilityEndDate = availabilityEndDate;
    }

    public int getBedroomCount() {
        return bedroomCount;
    }

    public void setBedroomCount(int bedroomCount) {
        this.bedroomCount = bedroomCount;
    }

    public int getBedCount() {
        return bedCount;
    }

    public void setBedCount(int bedCount) {
        this.bedCount = bedCount;
    }

    public int getGuestCount() {
        return guestCount;
    }

    public void setGuestCount(int guestCount) {
        this.guestCount = guestCount;
    }
}
