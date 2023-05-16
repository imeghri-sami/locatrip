package fr.n7.services;

import fr.n7.entities.Property;

import javax.ejb.Local;

@Local
public interface PropertyServiceLocal extends IDAO<Property, Integer> {

}
