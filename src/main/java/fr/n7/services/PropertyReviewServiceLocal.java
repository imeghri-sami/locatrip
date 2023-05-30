package fr.n7.services;


import fr.n7.entities.PropertyReview;

import javax.ejb.Local;
import java.util.List;

@Local
public interface PropertyReviewServiceLocal extends IDAO<PropertyReview, Integer> {
    List<PropertyReview> retrieveAllByPropertyId(int propertyId);
    List<PropertyReview> retrieveAllByPropertyId(int propertyId, int page, int size);
    void addReview(PropertyReview propertyReview);
}
