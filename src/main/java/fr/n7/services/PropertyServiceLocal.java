package fr.n7.services;

import fr.n7.entities.Property;

import javax.ejb.Local;
import java.util.List;

@Local
public interface PropertyServiceLocal extends IDAO<Property, Integer> {
    List<Property> findByType(String type);
}
